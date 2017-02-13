package controller;

import java.util.ArrayList;
import java.util.List;
import model.entity.User;
import service.UserServiceImpl;

public class RegistrationUser {
  private UserServiceImpl userService;

  public RegistrationUser() {
    userService = new UserServiceImpl();
  }


  public List<String> setRegistration(String firstname, String lastname, String email, String login,
      String password) {
    List<String> validate = validationRegistrationData(email, login);
    if (validate.size() == 0) {
      UserServiceImpl userService = new UserServiceImpl();
      User user = new User();
      user.setLogin(login);
      String encruptedString = new Encrupt().getEncryptedMd5ApacheAndAES(password);
      user.setPassword(encruptedString);
      user.setFirstname(firstname);
      user.setLastname(lastname);
      user.setEmail(email);
      userService.save(user);
      
    }
    return validate;
  }

  public List<String> validationRegistrationData(String email, String login) {
    List<String> result = new ArrayList<>();
    if (getExistLogin(login)) {
    } else {
      result.add("login");
    }
    if (getExistEmail(email)) {
      if (!new EmailValidator().validate(email)){
        result.add("emailNotCorrect");
      }
    } else {
      result.add("email");
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
