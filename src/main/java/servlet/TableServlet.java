package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.LaptopDao;
import dao.impl.LaptopDaoImpl;
import model.Laptop;
import model.Table;
import service.TableService;
import service.WorkWithJson;
import service.impl.TableServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/table")
public class TableServlet extends HttpServlet {

    private static final String PATH_JSON = "/home/andrey/IdeaProjects/FinalProjectJsp/src/main/resources/data/table.json";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TableService tableService = new TableServiceImpl();
        List<Table> table = tableService.getTable();

        WorkWithJson workWithJson = new WorkWithJson();
        workWithJson.setTableJson(table);

        ObjectMapper objectMapper = new ObjectMapper();
        List<Table> tables = objectMapper.readValue(new File(PATH_JSON), objectMapper.getTypeFactory()
                .constructCollectionType(List.class, Table.class));
        for (Table elem : tables) {
            req.setAttribute("imgPath", elem.getImgPath());
            req.setAttribute("name", elem.getName());
            req.setAttribute("diagonal", elem.getDiagonal());
            req.setAttribute("wifi", elem.getWifi());
            req.setAttribute("os", elem.getOs());
        }
    }
}
