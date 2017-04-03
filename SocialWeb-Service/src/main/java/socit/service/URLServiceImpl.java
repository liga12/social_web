package socit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socit.domain.URLDao;
import socit.domain.URLMassage;
import socit.domain.User;

import java.io.Serializable;
import java.util.List;

@Service
public class URLServiceImpl  implements URLService {

    @Autowired
    private URLDao urlDao;

    @Override
    public URLMassage byURLArgument(String argument, String column) {
        return urlDao.byURLArgument(argument, column);
    }

    @Override
    public URLMassage byId(Integer id) {
        return urlDao.byId(id);
    }

    @Override
    public Serializable save(URLMassage object) {
        return urlDao.save(object);
    }

    @Override
    public void update(URLMassage object) {
        urlDao.update(object);
    }

    @Override
    public void remove(URLMassage object) {
        urlDao.remove(object);
    }

    @Override
    public List<URLMassage> getList() {
        return (List<URLMassage>) urlDao.getList();
    }

}
