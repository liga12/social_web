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
    Validator validator = new Validator();
    List<String> validate =  validator.validationRegistrationData(email, login, password);
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
}
