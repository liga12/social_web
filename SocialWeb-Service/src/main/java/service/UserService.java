package service;

import java.io.Serializable;
import java.util.List;
import model.entity.User;


public interface UserService {

  User byId(Integer id);

  Serializable save(User user);

  void update(User user);

  void remove(User user);

  List<User> getList();

  User getUserAuthorization(String login, String password);

  User byUsername(String name);

  void registration(String firstname, String lastname, String email, String login, String password);

  User byUserlogin(String login);
}
