package service;

import model.Admin;
import model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    List<User> findUser();

    void deleteUser(String email);

    void updateUserPass(String email, String pass);
}
