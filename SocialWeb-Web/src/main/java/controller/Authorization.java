package controller;

import model.entity.User;
import service.UserServiceImpl;

public class Authorization {

  private UserServiceImpl userService;

  public Authorization() {
    userService = new UserServiceImpl();
  }

  public User getUserAuthorization(String login, String password) {
    String encruptedString = new Encrupt().getEncryptedMd5ApacheAndAES(password);
    User user = userService.byUserTwoArgument
        (login, "login", encruptedString, "password");
    return user;
  }
}
