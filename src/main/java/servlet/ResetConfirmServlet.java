package servlet;

import service.impl.EmailSenderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/resetConfirm")
public class ResetConfirmServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String confirm = req.getParameter("confirm");
        int randomConfirm = EmailSenderServiceImpl.randomResetConfirm;
        String randomConfirmString = String.valueOf(randomConfirm);

        if (confirm.equals(randomConfirmString)) {
            req.getRequestDispatcher("newResetPassword.jsp").forward(req, resp);

        } else {
            req.getRequestDispatcher("resetConfirm.jsp").forward(req, resp);
        }
    }
}
