import java.util.Objects;

public class Product {
  private String productID;
  private String name;
  private String description;
  private String category;
  private Double price;
  private Integer quantity;

  public Product(String productID, String name, String description, String category, Double price, Integer quantity) {
     this.productID = productID;
     this.name = name;
     this.description = description;
     this.category = category;
     this.price = price;
     this.quantity = quantity;
  }
  
  public Product(){
  }

  public String getProductID() {
     return productID;
  }

  public void setProductID(String productID) {
     this.productID = productID;
  }

  public String getName() {
     return name;
  }

  public void setName(String name) {
     this.name = name;
  }

  public String getDescription() {
     return description;
  }

  public void setDescription(String description) {
     this.description = description;
  }

  public String getCategory() {
     return category;
  }

  public void setCategory(String category) {
     this.category = category;
  }

  public Double getPrice() {
     return price;
  }

  public void setPrice(Double price) {
     this.price = price;
  }

  public Integer getQuantity() {
     return quantity;
  }

  public void setQuantity(Integer quantity) {
     this.quantity = quantity;
  }

  @Override
  public String toString() {
     return "ID: " + productID + ", Name: " + name;
  }
  
}