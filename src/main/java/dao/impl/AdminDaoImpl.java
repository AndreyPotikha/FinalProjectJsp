package dao.impl;

import config.Database;
import dao.AdminDao;
import model.Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

    private static final String ADD_ADMIN = "INSERT INTO admin (email, password, name) VALUE (?, ?, ?)";
    private static final String SEARCH_ADMIN = "SELECT * FROM admin";
    private static final String DELL_ADMIN = "DELETE FROM admin";

    @Override
    public void saveAdmin(Admin admin) {

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_ADMIN)){
            preparedStatement.setString(1, admin.getEmail());
            preparedStatement.setString(2, admin.getPassword());
            preparedStatement.setString(3, admin.getName());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Admin> findAdmin() {
        List<Admin> allAdmins = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SEARCH_ADMIN);

            while (resultSet.next()) {
                Admin searchAdmin = new Admin();
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                searchAdmin.setEmail(email);
                searchAdmin.setPassword(password);
                searchAdmin.setName(name);
                searchAdmin.setStatus("Admin");
                allAdmins.add(searchAdmin);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allAdmins;
    }

    @Override
    public void deleteAdmin() {
        try (Connection connection = Database.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELL_ADMIN)) {

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
