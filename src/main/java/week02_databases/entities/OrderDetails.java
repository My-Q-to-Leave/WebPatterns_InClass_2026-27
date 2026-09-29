package week02_databases.entities;

import java.sql.*;

public class OrderDetails {
    private int orderNumber;
    private String productCode;
    private int quantityOrdered;
    private double priceEach;
    private int orderLineNumber;

    public OrderDetails(int orderNumber, String productCode, int quantityOrdered, double priceEach, int orderLineNumber) {
        this.orderNumber = orderNumber;
        this.productCode = productCode;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof OrderDetails that)) return false;

        return orderNumber == that.orderNumber && productCode.equals(that.productCode);
    }

    @Override
    public int hashCode() {
        int result = orderNumber;
        result = 31 * result + productCode.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderNumber=" + orderNumber +
                ", productCode='" + productCode + '\'' +
                ", quantityOrdered=" + quantityOrdered +
                ", priceEach=" + priceEach +
                ", orderLineNumber=" + orderLineNumber +
                '}';
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public double getPriceEach() {
        return priceEach;
    }

    public int getOrderLineNumber() {
        return orderLineNumber;
    }

    public static class Product {
        static void main() {
            //LOAD DRIVER (Class.forName())

            // Create variables to hold database details
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/classicmodels";
            String username = "root";
            String password = "";

            //Load driver
            try {
                Class.forName(driver);


                //Connect to database
                try(Connection conn = DriverManager.getConnection(url, username, password)) {


                    //Prepare statement
                    String sql = "SELECT * FROM products";
                    try(PreparedStatement ps = conn.prepareStatement(sql)) {


                        //Run query
                        ResultSet rs = ps.executeQuery();

                        //Process results
                        while (rs.next()) {
                            System.out.println(rs.getString("productCode") + " | " +
                                    rs.getString("productName") + " | " +
                                    rs.getString("productLine") + " | " +
                                    rs.getString("productScale") + " | " +
                                    rs.getString("productVendor") + " | " +
                                    rs.getString("productDescription") + " | " +
                                    rs.getInt("quantityInStock") + " | " +
                                    rs.getDouble("buyPrice") + " | " +
                                    rs.getDouble("MSRP"));
                        }
                    }
                }catch(SQLException e) {
                    System.out.println("Cannot establish a connection to " + url);
                }

            } catch (ClassNotFoundException e) {
                System.out.println("No driver files found - please check dependencies.");
            }


        }
    }
}
