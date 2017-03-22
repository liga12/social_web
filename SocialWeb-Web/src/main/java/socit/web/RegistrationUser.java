package socit.web;


import javax.servlet.http.HttpServletRequest;

public interface RegistrationUser {

    String getFullUrl(HttpServletRequest req, String email);

}
