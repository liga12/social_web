package model.dao.entityDao;

import model.dao.AbstractDao;
import model.entity.URLMassage;
import model.entity.User;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 * Created by liga on 22.02.17.
 */
public class URLDaoImpl extends AbstractDao<URLMassage, Integer> {

  public URLMassage byArgument(String argument, String column) {
    return (URLMassage) HibernateUtil.getSessionFactory().openSession().createCriteria(URLMassage.class).
        add(Restrictions.eq(column, argument)).uniqueResult();
  }
}
