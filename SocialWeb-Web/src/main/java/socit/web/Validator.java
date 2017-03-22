package socit.web;


import java.util.List;

public interface Validator {

    Boolean validateEmail(String string);

    List<String> validationRegistrationData(String firstname, String lastname, String email,
                                            String login, String password, String passwordTwo);

    Boolean getExistLogin(String login);

    Boolean getExistEmail(String email);
}
