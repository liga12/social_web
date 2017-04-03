package socit.domain;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class URLDaoImpl extends AbstractDao<URLMassage, Integer> implements URLDao {

    @Transactional
    @Override
    public URLMassage byURLArgument(String argument, String column) {
        return (URLMassage) getCurrentSession().createCriteria(URLMassage.class).
                add(Restrictions.eq(column, argument)).uniqueResult();
    }
}
