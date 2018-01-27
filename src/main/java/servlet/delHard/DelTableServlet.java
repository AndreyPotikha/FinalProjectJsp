package servlet.delHard;

import service.PhoneService;
import service.TableService;
import service.impl.PhoneServiceImpl;
import service.impl.TableServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delTable")
public class DelTableServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        TableService tableService = new TableServiceImpl();
        tableService.delTable(name);

        req.getRequestDispatcher("table.jsp").forward(req, resp);
    }
}
