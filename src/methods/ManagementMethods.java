package methods;

import java.sql.*;

import static java.lang.System.*;

public class ManagementMethods {

    //ADD ITEMS
    public static void addProduct(Connection conn, String product_name, int quantity, double price) throws SQLException {
        String sql = "INSERT INTO products (product_name , quantity , price) VALUES(?, ? , ?)";
        try(PreparedStatement pstmt  = conn.prepareCall(sql)){
            pstmt.setString(1 , product_name);
            pstmt.setInt(2 , quantity);
            pstmt.setDouble(3 , price);
            pstmt.executeUpdate();
            out.println("Товар "+product_name+" добавлен в инвентарь.");
        }
    }

    //DELETE ITEMS
    public static void DeleteProduct(Connection conn , int productId ) throws SQLException {
        String sql = "DELETE FROM products WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1 , productId);
            pstmt.executeUpdate();
            out.println("Товар "+productId+" удален из инвентаря.");
        }

    }
///SHOW ALL ITEMS IN THE TABLE
    public static void getAllProducts(Connection conn) throws SQLException{
        String sql = "SELECT * FROM products";
        try(Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql)){
            while(resultSet.next()){
                int id = resultSet.getInt("product_id");
                String name = resultSet.getString("product_name");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                out.println("ID: " + id + ", Name: " + name + ", Quantity: " + quantity + ", Price: " + price);

            }
        }

    }

    //UPDATE ITEMS
    public static  void updateProducts(Connection conn , int product_id ,  String newName, int newQuantity, double newPrice) throws SQLException {
        String sql = "UPDATE products SET product_name = ? , quantity = ? , price = ? WHERE product_id = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1 , newName);
            pstmt.setInt(2, newQuantity);
            pstmt.setDouble(3, newPrice);
            pstmt.setInt(4, product_id);
            pstmt.executeUpdate();
            System.out.println("Информация о товаре "+ newName+" обновлена.");
        }
    }


}
