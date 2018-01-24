package dao.impl;

import config.Database;
import dao.TableDao;
import model.Phone;
import model.Table;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TableDaoImpl implements TableDao {

    private static final String FIND_TABLE = "SELECT * FROM `table`";

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
    public void delTable(Table table) {

    }

    @Override
    public void addTable(Table table) {

    }

    @Override
    public void updateTable(Table table) {

    }
}
