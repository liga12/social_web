package controller.filter;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/soc", "/logout"})
public class FilterByCookie implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession session = httpServletRequest.getSession();

        if (session != null) {
            Cookie[] cookies = httpServletRequest.getCookies();
            if (cookies != null) {
                Cookie reqCookie = null;
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("idSession")) {
                        reqCookie = cookie;
                        break;
                    }
                }
                if (reqCookie != null) {
                    if (reqCookie.getValue().equals(session.getId())) {
                        chain.doFilter(request, response);
                        return;
                    }
                }
            }
        }
        httpServletResponse.sendRedirect("/start");
    }

    @Override
    public void destroy() {

    }
}
