package dao.impl;

import config.Database;
import dao.LaptopDao;
import model.Laptop;
import model.User;
import service.WorkWithJson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LaptopDaoImpl implements LaptopDao {

    private static final String FIND_LAPTOP = "SELECT * FROM laptop";
    private static final String ADD_LAPTOP = "INSERT INTO laptop (name, cpu, ram, videoCard, hardMemory, imgPath) VALUE (?, ?, ?, ?, ?, ?)";
    private static final String DEL_LAPTOP = "DELETE FROM laptop WHERE name = (?)";
    private static final String UPDATE_LAPTOP = "UPDATE laptop SET cpu = (?), ram = (?), videoCard = (?), hardMemory = (?), imgPath = (?) WHERE name = (?)";

    @Override
    public List<Laptop> getLaptops() {

        List<Laptop> laptops = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(FIND_LAPTOP);

            while (resultSet.next()) {
                Laptop laptop = new Laptop();
                String name = resultSet.getString("name");
                String cpu = resultSet.getString("cpu");
                String ram = resultSet.getString("ram");
                String videoCard = resultSet.getString("videoCard");
                String hardMemory = resultSet.getString("hardMemory");
                String img = resultSet.getString("imgPath");
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
    public void delLaptops(String name) {
        try (Connection connection =Database.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DEL_LAPTOP)){

            preparedStatement.setString(1, name);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();

        }

        List<Laptop> laptops = getLaptops();

        WorkWithJson workWithJson = new WorkWithJson();
        workWithJson.setLaptopJson(laptops);
    }

    @Override
    public void addLaptops(Laptop laptop) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_LAPTOP)){

            preparedStatement.setString(1, laptop.getName());
            preparedStatement.setString(2, laptop.getCpu());
            preparedStatement.setString(3, laptop.getRam());
            preparedStatement.setString(4, laptop.getVideoCard());
            preparedStatement.setString(5, laptop.getHardMemory());
            preparedStatement.setString(6, laptop.getImgPath());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Laptop> laptops = getLaptops();

        WorkWithJson workWithJson = new WorkWithJson();
        workWithJson.setLaptopJson(laptops);
    }

    @Override
    public void updateLaptops(Laptop laptop) {

        try (Connection connection = Database.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LAPTOP)) {
            preparedStatement.setString(1, laptop.getCpu());
            preparedStatement.setString(2, laptop.getRam());
            preparedStatement.setString(3, laptop.getVideoCard());
            preparedStatement.setString(4, laptop.getHardMemory());
            preparedStatement.setString(5, laptop.getImgPath());
            preparedStatement.setString(6, laptop.getName());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Laptop> laptops = getLaptops();

        WorkWithJson workWithJson = new WorkWithJson();
        workWithJson.setLaptopJson(laptops);
    }
}
