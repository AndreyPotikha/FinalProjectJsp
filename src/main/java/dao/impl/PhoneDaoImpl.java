package dao.impl;

import config.Database;
import dao.PhoneDao;
import model.Laptop;
import model.Phone;
import service.WorkWithJson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneDaoImpl implements PhoneDao {

    private static final String FIND_PHONE = "SELECT * FROM phone";
    private static final String ADD_PHONE = "INSERT INTO phone (name, diagonal, wifi, os, imgPath)  VALUE (?, ?, ?, ?, ?)";
    @Override
    public List<Phone> getPhone() {

        List<Phone> phones = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(FIND_PHONE);

            while (resultSet.next()) {
                Phone phone = new Phone();
                String img = resultSet.getString("imgPath");
                String name = resultSet.getString("name");
                String diagonal = resultSet.getString("diagonal");
                String wifi = resultSet.getString("wifi");
                String os = resultSet.getString("os");
                phone.setName(name);
                phone.setDiagonal(diagonal);
                phone.setWifi(wifi);
                phone.setOs(os);
                phone.setImgPath(img);
                phones.add(phone);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return phones;
    }

    @Override
    public void delPhone(Phone phone) {

    }

    @Override
    public void addPhone(Phone phone) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_PHONE)){

            preparedStatement.setString(1, phone.getName());
            preparedStatement.setString(2, phone.getDiagonal());
            preparedStatement.setString(3, phone.getWifi());
            preparedStatement.setString(4, phone.getOs());
            preparedStatement.setString(5, phone.getImgPath());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Phone> phones = getPhone();

        WorkWithJson workWithJson = new WorkWithJson();
        workWithJson.setPhoneJson(phones);
    }

    @Override
    public void updatePhone(Phone phone) {

    }
}
