package socit.domain;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component()
public class UserDaoImpl extends AbstractDao<User, Integer> implements UserDao {

    @Transactional
    @Override
    public User byUserArgument(String argument, String column) {
        return (User) getCurrentSession().createCriteria(User.class).
                add(Restrictions.eq(column, argument)).uniqueResult();
    }

    @Transactional
    @Override
    public User byUserTwoArgument(String firstArgument, String firstColumn, String secondArgument, String secondColumn) {
        return (User) getCurrentSession().createCriteria(User.class).
                add(Restrictions.eq(firstColumn, firstArgument)).
                add(Restrictions.eq(secondColumn, secondArgument)).uniqueResult();
    }
}
