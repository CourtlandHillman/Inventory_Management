import methods.ManagementMethods;
import sql.InventoryManagementSystem;

import java.sql.Connection;
import java.sql.SQLException;

import static sql.InventoryManagementSystem.connectToDatabase;

public class Main {
    public static void main(String[] args) throws SQLException {


        Connection conn = connectToDatabase();
        try {
            // Здесь будет вызов методов для выполнения операций с инвентарем
            // Например: добавление товаров, удаление товаров, редактирование информации о товарах и т. д.
            ManagementMethods.addProduct( conn, "Gucci Sunglass Spring" , 10 , 1200);

            ManagementMethods.updateProducts(conn , 1 , "Prada sunglase office style winter ", 29 , 630);
            ManagementMethods.getAllProducts(conn);
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}