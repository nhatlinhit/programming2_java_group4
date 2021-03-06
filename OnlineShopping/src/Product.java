import java.util.Objects;
import java.util.Scanner;
public class Product {
   private String productId;
   private String name;
   private String description;
   private String category;
   private Double price;


  public Product(String productId, String name, String description, String category, Double price) {
     this.productId = productId;
     this.name = name;
     this.description = description;
     this.category = category;
     this.price = price;
  }
  
  public String getProductId() {
     return productId;
  }

  public void setProductId(String productId) {
     this.productId = productId;
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

  @Override
  public String toString() {
     return " - ID: #" + productId + "\n - Name: " + name + "\n - Description: " + description+ "\n - Category: " + category +  "\n - Price: " + price ;
  }
  
}