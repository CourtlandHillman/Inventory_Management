package sql;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class InventoryManagementSystem {


    static final String DB_URL = "jdbc:postgresql://localhost/Inventory";
    static final String USER = "postgres";
    static final String PASS = "12345";


    public static Connection connectToDatabase() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Подключение к базе данных установлено.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main (String [] args) throws SQLException {

    }


}
