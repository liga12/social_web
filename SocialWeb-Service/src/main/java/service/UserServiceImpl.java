package service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.dao.entityDao.UserDaoImpl;
import model.entity.User;
import model.entity.UserInform;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;


public class UserServiceImpl implements UserService {

  private UserDaoImpl userDao;

  public UserServiceImpl() {
    userDao = new UserDaoImpl();
  }

  @Override
  public User byId(Integer id) {
    return userDao.byId(id);
  }

  @Override
  public Serializable save(User user) {
    return userDao.save(user);
  }

  @Override
  public void update(User user) {
    userDao.update(user);
  }

  @Override
  public void remove(User user) {
    userDao.remove(user);
  }

  @Override
  public List<User> getList() {
    return userDao.getList();
  }


  @Override
  public User byUsername(String name) {
    return userDao.byUsername(name);
  }

  @Override
  public void registration(String firstname, String lastname, String email, String login,
      String password) {
    User user = new User();
    user.setLogin(login);
    user.setPassword(password);
    User user1 = byUserlogin(login);
    UserInform userInform = new UserInform();
    userInform.setFirstname(firstname);
    userInform.setLastname(lastname);
    userInform.setEmail(email);
    user.setUserInform(userInform);
    save(user);

//    new UserInformServiceImpl().save()
//    user1.setUserInform(userInform);
//    save(user1);



//    System.out.println(user);
//    UserInform userInform = new UserInform();
//    user.getUserInform().setFirstname(firstname);
//    user.getUserInform().setLastname(lastname);


  }

  @Override
  public User byUserlogin(String login) {
    return userDao.byUserlogin(login);
  }


  public User getUserAuthorization(String login, String password) {
    User user = (User) HibernateUtil.getSessionFactory().openSession().createCriteria(User.class).
        add(Restrictions.eq("login", login)).
        add(Restrictions.eq("password", password)).uniqueResult();
    if (user != null && user.getStatus() == true) {
      return user;
    } else {
      return null;
    }
  }
}

