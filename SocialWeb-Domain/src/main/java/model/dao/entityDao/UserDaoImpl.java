package model.dao.entityDao;

import model.dao.AbstractDao;
import model.entity.User;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class UserDaoImpl extends AbstractDao<User, Integer> implements UserDao {

  @Override
  public User byUsername(String name) {
    return (User) HibernateUtil.getSessionFactory().openSession().createCriteria(User.class).
        add(Restrictions.eq("username", name)).uniqueResult();
  }

  @Override
  public User byUserlogin(String login) {
    return (User) HibernateUtil.getSessionFactory().openSession().createCriteria(User.class).
        add(Restrictions.eq("login", login)).uniqueResult();
  }
}
