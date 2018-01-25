package servlet.newHard;

import model.Phone;
import model.Table;
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

@WebServlet("/newTable")
public class NewTable extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String diagonal = req.getParameter("diagonal");
        String wifi = req.getParameter("wifi");
        String os = req.getParameter("os");
        String imgPath = req.getParameter("imgPath");

        Table table = new Table();
        table.setName(name);
        table.setDiagonal(diagonal);
        table.setWifi(wifi);
        table.setOs(os);
        table.setImgPath(imgPath);

        TableService tableService = new TableServiceImpl();
        tableService.addTable(table);

        req.getRequestDispatcher("table.jsp").forward(req, resp);
    }
}
