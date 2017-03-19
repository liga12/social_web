package socit.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, I> {

    T byId(I id);

    Serializable save(T object);

    void update(T object);

    void remove(T object);

    List<T> getList();
}

