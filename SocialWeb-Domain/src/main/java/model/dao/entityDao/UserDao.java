package model.dao.entityDao;

import model.dao.BaseDao;
import model.entity.User;

public interface UserDao extends BaseDao<User, Integer> {

  User byUserArgument(String argument, String column);

  User byUserTwoArgument(String firstArgument, String firstColumn,
      String secondArgument, String secondColumn);
}
