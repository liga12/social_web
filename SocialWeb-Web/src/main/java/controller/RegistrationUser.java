package controller;

import model.entity.URLMassage;
import model.entity.User;
import service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

public class RegistrationUser {

    private UserServiceImpl userService;

    public RegistrationUser() {
        userService = new UserServiceImpl();
    }

    public List<String> setRegistration(String firstname, String lastname, String email, String login,
                                        String password, String passwordTwo, HttpServletRequest request) {

        Validator validator = new Validator();
        List<String> validate = validator.validationRegistrationData(firstname, lastname, email, login,
                password, passwordTwo);
        if (validate.size() == 0) {
            User user = new User();
            user.setLogin(login);
            user.setPassword(new Encrupt().getEncryptedMd5ApacheAndAES(password));
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setEmail(email);
            URLMassage urlMassage = new URLMassage();
            urlMassage.setUrl(getFullUrl(request, email));
            urlMassage.setUser(user);
            user.setUrlMassages(urlMassage);
            new UserServiceImpl().saveORUpdate(user);
            Mailer mailer = new Mailer();
            mailer.send(email, getFullUrl(request, email));
        }
        return validate;
    }

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
