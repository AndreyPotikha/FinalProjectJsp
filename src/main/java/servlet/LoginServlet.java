package servlet;

import model.User;
import service.CheckPassService;
import service.RegistrationSecurityService;
import service.UserService;
import service.impl.CheckPassServiceImpl;
import service.impl.RegistrationSecurityServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        CheckPassService checkPassService = new CheckPassServiceImpl();
        UserService userService = new UserServiceImpl();
        List<User> userList = userService.findUser();
        for (User elem : userList) {
            if (email.equals(elem.getEmail()) && checkPassService.checkPass(password)) {
                req.getRequestDispatcher("all.jsp").forward(req, resp);
            }
        }


        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
}
