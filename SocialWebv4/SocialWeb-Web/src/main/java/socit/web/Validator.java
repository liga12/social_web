package socit.web;

import org.springframework.beans.factory.annotation.Autowired;
import socit.domain.User;
import socit.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Autowired
    private UserService userService;

    public Boolean validateEmail(String string) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public List<String> validationRegistrationData(String firstname, String lastname, String email,
                                                   String login, String password, String passwordTwo) {
        List<String> result = new ArrayList<>();
        if (!firstname.equals(null)) {
            if (firstname.length() > 32) {
                result.add("Имя > 32");
            } else if (firstname.length() == 0) {
                result.add("Имя = 0");
            }
        } else {
            result.add("Имя = 0");
        }

        if (!lastname.equals(null)) {
            if (lastname.length() > 32) {
                result.add("Фамилия > 32");
            } else if (lastname.length() == 0) {
                result.add("Фамилия = 0");
            }
        } else {
            result.add("Фамилия = 0");
        }

        if (!login.equals(null)) {
            if (login.length() < 33) {
                if (login.length() != 0) {
                    if (!getExistLogin(login)) {
                        result.add("Логин существует");
                    }
                } else {
                    result.add("Логин = 0");
                }
            } else {
                result.add("Логин > 32");
            }
        } else {
            result.add("Логин = 0");
        }

        if (!email.equals(null)) {
            if (email.length() < 33) {
                if (email.length() != 0) {
                    if (new Validator().validateEmail(email)) {
                        if (!getExistEmail(email)) {
                            result.add("email уже существует");
                        }
                    } else {
                        result.add("email не корретный");
                    }
                } else {
                    result.add("email=0");
                }
            } else {
                result.add("email > 32 символов");
            }
        } else {
            result.add("email равен null");
        }

        if (password != null || passwordTwo != null) {
            if (password.equals(passwordTwo)) {
                if (password.length() < 33) {
                    if (password.length() == 0) {
                        result.add("Пароль = 0");
                    }
                } else {
                    result.add("Пароль > 32 символов");
                }
            } else {
                result.add("Пароли не совпадают");
            }
        } else {
            result.add("Пароль = null");
        }
        return result;
    }

    public Boolean getExistLogin(String login) {
        User user = userService.byUserArgument(login, "login");
        if (user == null) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean getExistEmail(String email) {
        User user = userService.byUserArgument(email, "email");
        if (user == null) {
            return true;
        } else {
            return false;
        }
    }
}


