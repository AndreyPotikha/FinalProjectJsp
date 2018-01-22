package service.impl;

import model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import service.CheckPassService;
import service.UserService;

import java.util.List;

public class CheckPassServiceImpl implements CheckPassService {
    @Override
    public boolean checkPass(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserService userService = new UserServiceImpl();
        List<User> user = userService.findUser();
        for (User elem : user) {
            if (passwordEncoder.matches(password, elem.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
