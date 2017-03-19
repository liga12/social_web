package socit.domain;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public abstract class AbstractDao<T, I extends Serializable> implements BaseDao<T, I> {

    private final Class<T> entityClass;

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public AbstractDao() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass
                .getActualTypeArguments()[0];
    }

    @Transactional
    @Override
    public T byId(I id) {
        Session session = getCurrentSession();
        return (T) session.load(entityClass, id);
    }

    @Transactional
    @Override
    public Serializable save(T object) {
        Session session = getCurrentSession();
        return session.save(object);
    }

    @Transactional
    @Override
    public void update(T object) {
        Session session = getCurrentSession();
        session.update(object);
    }

    @Transactional
    @Override
    public void remove(T object) {
        Session session = getCurrentSession();
        session.delete(object);
    }

    @Override
    public List<T> getList() {
        Session session = getCurrentSession();
        return (List<T>) session.createCriteria(entityClass).list();
    }
}