package dao.impl;

import config.Database;
import dao.LaptopDao;
import model.Laptop;
import model.User;
import service.WorkWithJson;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LaptopDaoImpl implements LaptopDao {

    private static final String FIND_LAPTOP = "SELECT * FROM laptop";

    @Override
    public List<Laptop> getLaptops() {

        List<Laptop> laptops = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(FIND_LAPTOP);

            while (resultSet.next()) {
                Laptop laptop = new Laptop();
                String img = resultSet.getString("imgPath");
                String name = resultSet.getString("name");
                String cpu = resultSet.getString("cpu");
                String ram = resultSet.getString("ram");
                String videoCard = resultSet.getString("videoCard");
                String hardMemory = resultSet.getString("hardMemory");
                laptop.setName(name);
                laptop.setCpu(cpu);
                laptop.setRam(ram);
                laptop.setVideoCard(videoCard);
                laptop.setHardMemory(hardMemory);
                laptop.setImgPath(img);
                laptops.add(laptop);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return laptops;
    }



    @Override
    public void delLaptops(Laptop laptop) {

    }

    @Override
    public void addLaptops(Laptop laptop) {

    }

    @Override
    public void updateLaptops(Laptop laptop) {

    }
}
