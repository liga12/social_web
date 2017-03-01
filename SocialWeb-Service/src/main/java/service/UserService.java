package service;

import java.io.Serializable;
import java.util.List;

import model.entity.User;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;


public interface UserService {

    User byId(Integer id);

    Serializable save(User user);

    void update(User user);

    void remove(User user);

    List<User> getList();

    User byUserTwoArgument(String firstArgument, String firstColumn,
                           String secondArgument, String secondColumn);

    public User byUserArgument(String argument, String column);


}
