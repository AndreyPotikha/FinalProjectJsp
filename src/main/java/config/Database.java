package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/jspfinal?useSSL=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "toor";

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
