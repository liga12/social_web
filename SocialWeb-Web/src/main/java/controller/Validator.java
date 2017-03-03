package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.entity.User;
import service.UserServiceImpl;

public class Validator {

  private Pattern pattern;
  private Matcher matcher;
  private static final String EMAIL_PATTERN =
      "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
          + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
  private UserServiceImpl userService;

  public Validator() {
    userService = new UserServiceImpl();
  }

  public Boolean validateEmail(String string) {
    pattern = Pattern.compile(EMAIL_PATTERN);
    matcher = pattern.matcher(string);
    return matcher.matches();
  }

  public List<String> validationRegistrationData(String email, String login, String password) {
    List<String> result = new ArrayList<>();
    if (getExistLogin(login)) {
    } else {
      result.add("login");
    }
    if (new Validator().validateEmail(email)) {
      if (getExistEmail(email)) {
      } else {
        result.add("email");
      }
    } else {
      result.add("emailNotCorrect");
    }
    if (password.length()<6){
      result.add("password < 6");
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


