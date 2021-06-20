import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;

public class WriteProductData {
  
  public void writeProducts() throws IOException {
    
    boolean continueInputData = true;
    int isContinue = 1;
    FileWriter myWriter = new FileWriter("productsData.txt", true); // false replace file

    do {
      Scanner input = new Scanner(System.in);
      Product newProduct = inputProduct(input);

      String productId = newProduct.getProductId();
      String name = newProduct.getName();
      String desc = newProduct.getDescription();
      String category = newProduct.getCategory();
      double price = newProduct.getPrice();
      
      System.out.println("Product info: \n - ID: " + productId + "\n - Name: " + name + "\n - Description: " + desc+ "\n - Category: " + category +  "\n - Price: " + price );

      String productDataLine =  productId + "/" + name + "/" + desc + "/" + category + "/" + price + "\n";

      myWriter.write(productDataLine);

      System.out.println("\nContinue input next product? \n [1] Yes  [2] No ");

      isContinue = input.nextInt();

      if ( isContinue == 2 ) {
          input.close();
          myWriter.close();
          System.out.println("Successfully wrote to the file.");
          continueInputData = false;
      }
        
    }while(continueInputData);
  }

  public static Product inputProduct(Scanner input) {
    
    System.out.println("===== Create new product ===== ");
    
    System.out.print("Enter id: ");
    String productId = input.nextLine();

    System.out.print("Enter product's name: ");
    String name = input.nextLine();

    System.out.print("Enter product's description: ");
    String desc = input.nextLine();

    System.out.print("Enter product's category: ");
    String category = input.nextLine();

    System.out.print("Enter product's price: ");
    Double price = input.nextDouble();

    Product inputProd = new Product(productId, name, desc, category, price);

    return inputProd;
  }

}
