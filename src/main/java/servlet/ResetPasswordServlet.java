package servlet;


import model.User;
import service.EmailSenderService;
import service.UserService;
import service.impl.EmailSenderServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/resetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {

    public static String email;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        email = req.getParameter("email");

        UserService userService = new UserServiceImpl();
        List<User> userList = userService.findUser();

        for (User elem : userList) {
            if (email.equals(elem.getEmail())) {
                EmailSenderService senderService = new EmailSenderServiceImpl();
                senderService.sendEmail(email);

                req.getRequestDispatcher("resetConfirm.jsp").forward(req, resp);
            }
        }

        req.getRequestDispatcher("resetPassword.jsp").forward(req, resp);
    }
}
