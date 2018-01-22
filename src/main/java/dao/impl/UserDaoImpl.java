package dao.impl;

import config.Database;
import dao.UserDao;
import model.Admin;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final String SAVE_USER = "INSERT INTO user (email, password, status) VALUE (?,?,?)";
    private static final String FIND_USER = "SELECT * FROM user";
    private static final String DELETE_USER = "INSERT INTO user (email, password, status) VALUE ()";
    private static final String UPDATE_USER = "UPDATE user SET password (?) WHERE email (?)";



    @Override
    public void saveUser(User user) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER)) {
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getStatus());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<User> findUser() {

        List<User> userList = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(FIND_USER);

            while (resultSet.next()) {
                User searchUser = new User();
                String email = resultSet.getString("email");
                searchUser.setEmail(email);
                userList.add(searchUser);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public void deleteUser(String email) {

    }

    @Override
    public void updateUserPass(String email, String pass) {

        try (Connection connection = Database.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {
            preparedStatement.setString(1, pass);
            preparedStatement.setString(2,email);

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
