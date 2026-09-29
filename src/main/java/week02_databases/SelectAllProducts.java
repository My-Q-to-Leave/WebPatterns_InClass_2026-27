package week02_databases;

import week02_databases.entities.Product;

import java.sql.*;
import java.util.ArrayList;

public class SelectAllProducts {

    public static void main(String[] args) {

        // Database details
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/classicmodels";
        String username = "root";
        String password = "";

        // Load driver
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
            return;
        }

        // a. Open a connection to classicmodels
        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            // Prepare statement
            String sql = "SELECT * FROM products";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {

                // Run query
                try (ResultSet rs = ps.executeQuery()) {

                    // b. Store each row as a Product in an ArrayList
                    ArrayList<Product> products = new ArrayList<>();

                    while (rs.next()) {

                                String productCode = rs.getString("productCode");
                                String productName = rs.getString("productName");
                                String productLine = rs.getString("productLine");
                                String productScale = rs.getString("productScale");
                                String productVendor = rs.getString("productVendor");
                                String productDescription = rs.getString("productDescription");
                                int quantityInStock = rs.getInt("quantityInStock");
                                double buyPrice = rs.getDouble("buyPrice");
                                double MSRP = rs.getDouble("MSRP");

                        Product p = new Product(productCode, productName, productLine, productScale, productVendor, productDescription,quantityInStock, buyPrice, MSRP);
                        products.add(p);
                    }

                    // c. Display the ArrayList
                        System.out.println(products);

                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}