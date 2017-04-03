package socit.web;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface RegistrationUser {

    String getFullUrl(HttpServletRequest req, String email);

    List<String> setRegistration(String firstname, String lastname, String email, String login,
                                 String password, String passwordTwo, HttpServletRequest request);

}
