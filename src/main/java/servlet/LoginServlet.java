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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        CheckPassService checkPassService = new CheckPassServiceImpl();
        UserService userService = new UserServiceImpl();
        List<User> userList = userService.findUser();


        for (User elem : userList) {
            if (email.equals(elem.getEmail()) && checkPassService.checkPass(password)) {
                session.setAttribute("userEmail", elem.getEmail());
                session.setAttribute("userStatus", elem.getStatus());
                session.setAttribute("userName", elem.getName());
                req.getRequestDispatcher("homeInfo.jsp").forward(req, resp);
            }
        }

        LaptopServlet laptopServlet = new LaptopServlet();
        laptopServlet.doPost(req,resp);

        PhoneServlet phoneServlet = new PhoneServlet();
        phoneServlet.doPost(req, resp);

        TableServlet tableServlet = new TableServlet();
        tableServlet.doPost(req, resp);

        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
}
