package servlet;

import model.Admin;
import model.User;
import service.AdminService;
import service.impl.EmailSenderAdminServiceImpl;
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

@WebServlet("/confirm")
public class ConfirmServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String confirm = req.getParameter("confirm");
        int randomConfirm = EmailSenderAdminServiceImpl.randomConfirm;
        String randomConfirmStrin = String.valueOf(randomConfirm);
        System.out.println(randomConfirm);

        if (confirm.equals(randomConfirmStrin)) {
            req.getRequestDispatcher("all.jsp").forward(req, resp);
            AdminService adminService = new AdminServiceImpl();
            List<Admin> admin = adminService.findAdmin();
            User user = new User();
            for (Admin elem : admin) {
                user.setEmail(elem.getEmail());
                user.setPassword(elem.getPassword());
                user.setStatus(elem.getStatus());
            }
            UserService userService = new UserServiceImpl();
            userService.saveUser(user);
            adminService.deleteAdmin();

        } else {
            req.getRequestDispatcher("confirmation.jsp").forward(req, resp);
        }
    }
}
