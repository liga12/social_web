package socit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import socit.domain.URLMassage;
import socit.domain.User;
import socit.service.URLService;
import socit.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component
public class RegistrationUserImp implements RegistrationUser {

    @Autowired
    private UserService userService;
    @Autowired
    private URLService urlService;
//    @Autowired
//    private Validator validator;

    @Override
    public List<String> setRegistration(String firstname, String lastname, String email, String login,
                                        String password, String passwordTwo, HttpServletRequest request) {


//        List<String> validate = validator.validationRegistrationData(firstname, lastname, email, login,
//                password, passwordTwo);
//        if (validate.size() == 0) {
            User user = new User();
            user.setLogin(login);
//            user.setPassword(new Encrupt().getEncryptedMd5ApacheAndAES(password));
            user.setPassword(password);
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setEmail(email);
            userService.save(user);
            URLMassage urlMassage = new URLMassage();
            urlMassage.setUrl(getFullUrl(request, email));
            urlMassage.setUser(user);
            urlService.save(urlMassage);
            Mailer mailer = new Mailer();
            mailer.send(email, getFullUrl(request, email));
         List<String> sss  =new ArrayList<>();
//        }
        return sss ;
    }

    @Override
    public String getFullUrl(HttpServletRequest req, String email){
        Encrupt encrupt = new Encrupt();
        String scheme = req.getScheme();
        String serverName = req.getServerName();
        StringBuilder url = new StringBuilder();
        url.append(scheme).append("://").append(serverName);
        url.append(":").append(req.getServerPort());
        url.append("/emailRegis/").append(encrupt.getEncryptedMd5(email));
        return url.toString();
    }
}
