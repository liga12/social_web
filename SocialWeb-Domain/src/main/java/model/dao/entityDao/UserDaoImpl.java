package model.dao.entityDao;

import model.dao.AbstractDao;
import model.entity.User;
import org.hibernate.criterion.Restrictions;
import util.SessionClass;

public class UserDaoImpl extends AbstractDao<User, Integer> implements UserDao {

    @Override
    public User byUserArgument(String argument, String column) {
        return (User) SessionClass.getSession().createCriteria(User.class).
                add(Restrictions.eq(column, argument)).uniqueResult();
    }

    @Override
    public User byUserTwoArgument(String firstArgument, String firstColumn, String secondArgument,
                                  String secondColumn) {
        return (User) SessionClass.getSession().createCriteria(User.class).
                add(Restrictions.eq(firstColumn, firstArgument)).
                add(Restrictions.eq(secondColumn, secondArgument)).uniqueResult();
    }
}
