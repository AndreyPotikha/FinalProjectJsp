package servlet.updateHard;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.j256.ormlite.support.DatabaseResults;
import config.Database;
import model.Laptop;
import service.LaptopService;
import service.WorkWithJson;
import service.impl.LaptopServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/updateLaptop")
public class UpdateLaptopServlet extends HttpServlet {

    private static final String INSERT_LAPTOP = "SELECT * FROM laptop WHERE name = (?)";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String incomingName  = req.getParameter("name");

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LAPTOP)) {

            preparedStatement.setString(1, incomingName);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String cpu = resultSet.getString("cpu");
                String ram = resultSet.getString("ram");
                String videoCard = resultSet.getString("videoCard");
                String hardMemory = resultSet.getString("hardMemory");
                String imgPath = resultSet.getString("imgPath");

                req.setAttribute("name", name);
                req.setAttribute("cpu", cpu);
                req.setAttribute("ram", ram);
                req.setAttribute("videoCard", videoCard);
                req.setAttribute("hardMemory", hardMemory);
                req.setAttribute("imgPath", imgPath);
            }

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        req.getRequestDispatcher("updateLaptop.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String cpu = req.getParameter("cpu");
        String ram = req.getParameter("ram");
        String videoCard = req.getParameter("videoCard");
        String hardMemory = req.getParameter("hardMemory");
        String imgPath = req.getParameter("imgPath");

        Laptop laptop = new Laptop();
        laptop.setName(name);
        laptop.setCpu(cpu);
        laptop.setRam(ram);
        laptop.setVideoCard(videoCard);
        laptop.setHardMemory(hardMemory);
        laptop.setImgPath(imgPath);

        LaptopService laptopService = new LaptopServiceImpl();
        laptopService.updateLaptops(laptop);

        req.getRequestDispatcher("laptop.jsp").forward(req,resp);
    }
}
