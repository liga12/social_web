package service;

import java.io.Serializable;
import java.util.List;

import model.dao.entityDao.UserDaoImpl;
import model.entity.User;

public class UserServiceImpl implements UserService {

    private UserDaoImpl userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public User byId(Integer id) {
        return userDao.byId(id);
    }

    @Override
    public Serializable save(User user) {
        return userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void remove(User user) {
        userDao.remove(user);
    }

    @Override
    public List<User> getList() {
        return userDao.getList();
    }

    @Override
    public User byUserArgument(String argument, String column) {
        return userDao.byUserArgument(argument, column);
    }

    @Override
    public User byUserTwoArgument(String firstArgument, String firstColumn, String secondArgument,
                                  String secondColumn) {
        return userDao.byUserTwoArgument(firstArgument, firstColumn, secondArgument, secondColumn);
    }
}


