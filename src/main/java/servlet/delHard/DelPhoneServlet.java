package servlet.delHard;

import service.LaptopService;
import service.PhoneService;
import service.impl.LaptopServiceImpl;
import service.impl.PhoneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delPhone")
public class DelPhoneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        PhoneService phoneService = new PhoneServiceImpl();
        phoneService.delPhones(name);

        req.getRequestDispatcher("phone.jsp").forward(req, resp);
    }
}
