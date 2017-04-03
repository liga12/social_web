package socit.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import socit.domain.User;
import socit.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('ROLE_USER')")
                .and().formLogin().loginPage("/login").permitAll()
                .usernameParameter("login")
                .defaultSuccessUrl("/admin/home", false).and().logout().logoutUrl("/logout");
        http.sessionManagement().maximumSessions(100).sessionRegistry(sessionRegistry());
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    //исп для указания мах кол-ва сессий
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            private final ShaPasswordEncoder sha = new ShaPasswordEncoder();

            @Override
            public String encode(CharSequence cs) {
                return sha.encodePassword(cs.toString(), 1);
            }

            @Override
            @SuppressWarnings("PMD")
            public boolean matches(CharSequence cs, String string) {
                System.out.println("pass cs == " + sha.encodePassword(cs.toString(), 1));
                System.out.println("pass str == " + string);
                return (sha.encodePassword(cs.toString(), 1)).equals(string);
            }
        };
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(passwordEncoder());
        authProvider.setUserDetailsService(userDetailsService());
        return authProvider;
    }

    @Override
    public UserDetailsService userDetailsService() {
        UserDetailsService detailsService = new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
                User user;
                try {
                    user = userService.byUserArgument(login, "login");
                } catch (Exception ex) {
                    System.out.println("user not found or error");
                    ex.printStackTrace();
                    throw new UsernameNotFoundException("can't find user@login" + login);
                }
                if (user == null) {
                    throw new UsernameNotFoundException("can't find user@ulogin" + login);
                }
                return  (UserDetails) user;
            }
        };
        return detailsService;
    }

    @Bean
    public AuthenticationDetailsSource authenticationDetailsSource() {
        return new WebAuthenticationDetailsSource() {
            public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
                return new WebAuthenticationDetails(context);
            }
        };

    }
}
