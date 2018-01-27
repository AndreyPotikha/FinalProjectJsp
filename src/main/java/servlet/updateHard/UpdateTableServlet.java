package servlet.updateHard;

import config.Database;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/updateTable")
public class UpdateTableServlet extends HttpServlet {

    private static final String INSERT_TABLE = "SELECT * FROM `table` WHERE name = (?)";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String incomingName  = req.getParameter("name");

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TABLE)) {

            preparedStatement.setString(1, incomingName);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String diagonal = resultSet.getString("diagonal");
                String wifi = resultSet.getString("wifi");
                String os = resultSet.getString("os");
                String imgPath = resultSet.getString("imgPath");

                req.setAttribute("name", name);
                req.setAttribute("diagonal", diagonal);
                req.setAttribute("wifi", wifi);
                req.setAttribute("os", os);;
                req.setAttribute("imgPath", imgPath);
            }

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        req.getRequestDispatcher("updateTable.jsp").forward(req,resp);
    }

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
        tableService.updateTable(table);

        req.getRequestDispatcher("table.jsp").forward(req,resp);
    }
}
