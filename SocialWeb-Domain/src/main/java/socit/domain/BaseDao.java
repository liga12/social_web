package socit.domain;

import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, I> {
    @Transactional
    T byId(I id);

    @Transactional
    Serializable save(T object);

    @Transactional
    void update(T object);

    @Transactional
    void remove(T object);

    List<T> getList();
}
