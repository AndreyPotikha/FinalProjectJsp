package service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import service.RegistrationSecurityService;

public class RegistrationSecurityServiceImpl implements RegistrationSecurityService {

    public String registrationService(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode(password);
        return encode;
    }
}
