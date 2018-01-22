package servlet;

import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/newResetPassword")
public class ResetNewPasswordServlate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String password = req.getParameter("password");

        UserService userService = new UserServiceImpl();
        String email = ResetPasswordServlet.email;
        userService.updateUserPass(email, password);
    }
}
