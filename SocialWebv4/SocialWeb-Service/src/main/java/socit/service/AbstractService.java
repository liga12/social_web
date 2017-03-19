package socit.service;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import socit.domain.BaseDao;

@Component
public abstract class AbstractService<T, I extends Serializable> implements BaseService<T, I> {

    @Autowired
    private BaseDao dao;


    @Transactional
    @Override
    public T byId(I id) {
        return (T) dao.byId(id);
    }

    @Transactional
    @Override
    public Serializable save(T object) {
        return dao.save(object);
    }

    @Transactional
    @Override
    public void update(T object) {
        dao.update(object);
    }

    @Transactional
    @Override
    public void remove(T object) {
        dao.remove (object);
    }

    @Override
    public List<T> getList() {

        return (List<T>) dao.getList();
    }
}