package servlet.delHard;

import service.LaptopService;
import service.impl.LaptopServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delLaptop")
public class DelLaptopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        LaptopService laptopService = new LaptopServiceImpl();
        laptopService.delLaptops(name);

        req.getRequestDispatcher("laptop.jsp").forward(req, resp);
    }
}
