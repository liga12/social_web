package model.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import model.dao.BaseDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;
import util.SessionClass;

public abstract class AbstractDao<T, I extends Serializable> implements BaseDao<T, I> {

    private final Class<T> entityClass;

    public AbstractDao() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().
                getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.
                getActualTypeArguments()[0];
    }

    @Override
    public T byId(I id) {
        Session session = SessionClass.getSession();
        return (T) session.load(entityClass, (Serializable) id);
    }

    @Override
    public Serializable save(T object) {
        Serializable saver = null;
        Session session = SessionClass.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            saver = session.save(object);
            session.flush();
            session.clear();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return saver;
    }

    @Override
    public void saveORUpdate(T object) {
        Session session = SessionClass.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            session.saveOrUpdate(object);
            session.flush();
            session.clear();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(T object) {
        Session session = SessionClass.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            session.update(object);
            session.flush();
            session.clear();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void remove(T object) {
        Session session = SessionClass.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            session.delete(object);
            session.flush();
            session.clear();
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
