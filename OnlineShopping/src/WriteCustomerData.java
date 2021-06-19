
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;

public class WriteCustomerData {
  public static void main(String[] args) throws IOException {
    
    boolean continueInputData = true;
    int isContinue = 1;
    FileWriter myWriter = new FileWriter("customers.txt", false); // false replace file
    int id = 1;
    
    do {
      System.out.println("===== Create new user ===== ");
      Scanner input = new Scanner(System.in);
      System.out.print("Enter username: ");
      String username = input.nextLine();
      System.out.print("Enter password: ");
      String password = input.nextLine();
      System.out.print("Enter customer's name: ");
      String name = input.nextLine();
      System.out.print("Enter customer's address: ");
      String address = input.nextLine();
      System.out.print("Enter customer's credit card number: ");
      String creditCard = input.nextLine();
      
      System.out.println("\nCustomer info: \n - Username: " + username + "\n - Password: " + password + "\n - Name: " + name + "\n - Address: " + address + "\n - Credit card: " + creditCard );

      String customerDataLine =  id + "/" + username + "/" + password + "/" + name + "/" + address + "/" + creditCard + "\n";

      myWriter.write(customerDataLine);
      id++;

      System.out.println("\nContinue input customer data? \n [1] Yes  [2] No ");

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
