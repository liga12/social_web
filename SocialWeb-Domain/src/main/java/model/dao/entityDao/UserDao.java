package model.dao.entityDao;
//
import model.dao.BaseDao;
import model.entity.User;

public interface UserDao extends BaseDao<User, Integer> {
  User byUsername(String name);
  User byUserlogin(String login);
}
