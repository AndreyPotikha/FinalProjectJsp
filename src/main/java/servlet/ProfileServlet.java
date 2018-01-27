package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = String.valueOf(req.getSession().getAttribute("userName"));
        String email = String.valueOf(req.getSession().getAttribute("userEmail"));
        String status = String.valueOf(req.getSession().getAttribute("userStatus"));

        req.setAttribute("name", name);
        req.setAttribute("email", email);
        req.setAttribute("status", status);

        req.getRequestDispatcher("profile.jsp").forward(req, resp);
    }
}
