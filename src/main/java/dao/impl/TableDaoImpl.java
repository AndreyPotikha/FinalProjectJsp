package dao.impl;

import config.Database;
import dao.TableDao;
import model.Phone;
import model.Table;
import service.WorkWithJson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableDaoImpl implements TableDao {

    private static final String FIND_TABLE = "SELECT * FROM `table`";
    private static final String ADD_TABLE = "INSERT INTO `table` (name, diagonal, wifi, os, imgPath)   VALUE (?, ?, ?, ?, ?)";
    private static final String DEL_TABLE = "DELETE FROM `table` WHERE name = (?)";
    private static final String UPDATE_TABLE = "UPDATE `table` SET diagonal = (?), wifi = (?), os = (?), imgPath = (?) WHERE name = (?)";


    @Override
    public List<Table> getTable() {
        List<Table> tables = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(FIND_TABLE);

            while (resultSet.next()) {
                Table table = new Table();
                String img = resultSet.getString("imgPath");
                String name = resultSet.getString("name");
                String diagonal = resultSet.getString("diagonal");
                String wifi = resultSet.getString("wifi");
                String os = resultSet.getString("os");
                table.setName(name);
                table.setDiagonal(diagonal);
                table.setWifi(wifi);
                table.setOs(os);
                table.setImgPath(img);
                tables.add(table);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tables;
    }

    @Override
    public void delTable(String name) {
        try (Connection connection =Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DEL_TABLE)){

            preparedStatement.setString(1, name);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();

        }

        List<Table> tables = getTable();

        WorkWithJson workWithJson = new WorkWithJson();
        workWithJson.setTableJson(tables);
    }

    @Override
    public void addTable(Table table) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_TABLE)){

            preparedStatement.setString(1, table.getName());
            preparedStatement.setString(2, table.getDiagonal());
            preparedStatement.setString(3, table.getWifi());
            preparedStatement.setString(4, table.getOs());
            preparedStatement.setString(5, table.getImgPath());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Table> tables = getTable();

        WorkWithJson workWithJson = new WorkWithJson();
        workWithJson.setTableJson(tables);
    }

    @Override
    public void updateTable(Table table) {

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TABLE)) {
            preparedStatement.setString(1, table.getDiagonal());
            preparedStatement.setString(2, table.getWifi());
            preparedStatement.setString(3, table.getOs());
            preparedStatement.setString(4, table.getImgPath());
            preparedStatement.setString(5, table.getName());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Table> tables = getTable();

        WorkWithJson workWithJson = new WorkWithJson();
        workWithJson.setTableJson(tables);
    }
}
