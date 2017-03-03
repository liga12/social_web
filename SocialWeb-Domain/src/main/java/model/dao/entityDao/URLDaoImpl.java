package model.dao.entityDao;

import model.dao.AbstractDao;
import model.entity.URLMassage;
import org.hibernate.criterion.Restrictions;
import util.SessionClass;

public class URLDaoImpl extends AbstractDao<URLMassage, Integer> {

    public URLMassage byArgument(String argument, String column) {
        return (URLMassage) SessionClass.getSession().createCriteria(URLMassage.class).
                add(Restrictions.eq(column, argument)).uniqueResult();
    }
}
