package model.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import model.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public abstract class AbstractDao<T, I extends Serializable> implements BaseDao<T, I> {

  private final Class<T> entityClass;

  private SessionFactory sessionFactory;

//  protected Session getCurrentSession(){
//    return HibernateUtil.getSessionFactory();
//  }

  public AbstractDao() {
    ParameterizedType genericSuperclass = (ParameterizedType) getClass().
        getGenericSuperclass();
    this.entityClass = (Class<T>) genericSuperclass.
        getActualTypeArguments()[0];
  }


  @Override
  public T byId(I id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    return (T) session.load(entityClass, (Serializable) id);
  }

  @Override
  public Serializable save(T object) {
    Serializable saver = null;
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    try {
      saver = session.save(object);
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      e.printStackTrace();
    }
    return saver;
  }

  @Override
  public void update(T object) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    try {
      session.update(object);
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      e.printStackTrace();
    }
  }

  @Override
  public void remove(T object) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    try {
      session.delete(object);
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      e.printStackTrace();
    }

  }

  @Override
  public List getList() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    return (List<T>) session.createCriteria(entityClass).list();
  }
}
