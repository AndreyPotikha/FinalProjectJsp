package servlet;


import model.Admin;
import model.User;
import service.EmailSenderAdminService;
import service.RegistrationSecurityService;
import service.impl.EmailSenderAdminServiceImpl;
import service.impl.RegistrationSecurityServiceImpl;
import service.AdminService;
import service.UserService;
import service.impl.AdminServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String checkbox = req.getParameter("checkbox");

        RegistrationSecurityService registrationSecurityService = new RegistrationSecurityServiceImpl();
        String encodPass = registrationSecurityService.registrationService(password);

        if (checkbox != null) {
            Admin admin = new Admin();
            admin.setEmail(email);
            admin.setPassword(encodPass);
            AdminService adminService = new AdminServiceImpl();
            adminService.deleteAdmin();
            UserService userService = new UserServiceImpl();
            List<User> findUsers = userService.findUser();
            int calc = findUsers.size();
            for (User elem : findUsers) {
                if (admin.getEmail().equals(elem.getEmail())) {
                    calc--;
                }
            }
            if (calc != findUsers.size()) {
                req.getRequestDispatcher("registration.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("confirmation.jsp").forward(req, resp);
                adminService.saveAdmin(admin);
                EmailSenderAdminService emailSenderService = new EmailSenderAdminServiceImpl();
                emailSenderService.sendEmail(admin);
            }
        } else {
            User user = new User();
            user.setEmail(email);
            user.setPassword(encodPass);
            user.setStatus("User");

            UserService userService = new UserServiceImpl();
            List<User> userList = userService.findUser();
            int calc = userList.size();
            for (User elem : userList) {
                if (user.getEmail().equals(elem.getEmail())) {
                    calc--;
                }
            }
            if (calc != userList.size()) {
                req.getRequestDispatcher("registration.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("homeInfo.jsp").forward(req, resp);
                userService.saveUser(user);
            }
        }

    }
}
