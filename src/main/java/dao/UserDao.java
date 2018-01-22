package dao;

import model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    List<User> findUser();

    void deleteUser(String email);

    void updateUserPass(String email, String pass);
}
