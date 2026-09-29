package week02_databases.entities;

import java.util.Objects;

/**
 * DTO (Data Transfer Object) modelling one row of the classicmodels.products table.
 * Immutable: fields are final and there are no setters.
 */
public class Product {

    // One variable per column, types matched to the table
    private String productCode;         // varchar(15), primary key
    private String productName;         // varchar(70)
    private String productLine;         // varchar(50), foreign key -> productlines
    private String productScale;        // varchar(10)
    private String productVendor;       // varchar(50)
    private String productDescription;  // text
    private int quantityInStock;        // smallint
    private double buyPrice;            // double
    private double msrp;                // double (MSRP column)

    public Product(String productCode, String productName, String productLine, String productScale, String productVendor, String productDescription, int quantityInStock, double buyPrice, double msrp) {
        this.productCode = productCode;
        this.productName = productName;
        this.productLine = productLine;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.productDescription = productDescription;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
        this.msrp = msrp;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductLine() {
        return productLine;
    }

    public String getProductScale() {
        return productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public double getMsrp() {
        return msrp;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productLine='" + productLine + '\'' +
                ", productScale='" + productScale + '\'' +
                ", productVendor='" + productVendor + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", buyPrice=" + buyPrice +
                ", msrp=" + msrp +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productCode, product.productCode);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productCode);
    }
}