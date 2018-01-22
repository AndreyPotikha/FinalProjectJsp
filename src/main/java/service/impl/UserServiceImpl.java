package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public void saveUser(User user) {
        UserDao userDao = new dao.impl.UserDaoImpl();
        userDao.saveUser(user);
    }

    @Override
    public List<User> findUser() {
        UserDao userDao = new dao.impl.UserDaoImpl();
        return userDao.findUser();
    }

    @Override
    public void deleteUser(String email) {
        UserDao userDao = new dao.impl.UserDaoImpl();
        userDao.deleteUser(email);
    }

    @Override
    public void updateUserPass(String email, String pass) {
        UserDao userDao = new UserDaoImpl();
        userDao.updateUserPass(email, pass);
    }
}
