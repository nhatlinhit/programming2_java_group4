import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;

public class WriteProductData {
  public static void main(String[] args) throws IOException {
    
    boolean continueInputData = true;
    int isContinue = 1;
    FileWriter myWriter = new FileWriter("products.txt", false); // false replace file
    
    do {
      System.out.println("===== Create new product ===== ");
      Scanner input = new Scanner(System.in);
      System.out.print("Enter id: ");
      String productId = input.nextLine();
      System.out.print("Enter product's name: ");
      String name = input.nextLine();
      System.out.print("Enter product's description: ");
      String desc = input.nextLine();
      System.out.print("Enter product's price: ");
      Double price = input.nextDouble();
      System.out.print("Enter product's quantity: ");
      int quantity = input.nextInt();
      
      System.out.println("Product info: \n - ID: " + productId + "\n - Name: " + name + "\n - Description: " + desc + "\n - Price: " + price + "\n - Quantity: " + quantity );

      String productDataLine =  productId + "/" + name + "/" + desc + "/" + price + "/" + quantity + "\n";

      myWriter.write(productDataLine);

      System.out.println("\nContinue input next product data? \n [1] Yes  [2] No ");

      isContinue = input.nextInt();

      if ( isContinue == 2 ) {
          input.close();
          myWriter.close();
          System.out.println("Successfully wrote to the file.");
          continueInputData = false;
      }
        
    }while(continueInputData);
  }

}
