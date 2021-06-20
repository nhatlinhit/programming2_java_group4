
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;

public class WriteUserData {
  public void writeUsers() throws IOException {
    
    boolean continueInputData = true;
    int isContinue = 1;
    FileWriter myWriter = new FileWriter("usersData.txt", true); // false replace file
    int count = 1;
    
    do {
      System.out.println("===== Create new user ===== ");
      Scanner input = new Scanner(System.in);
      System.out.print("Enter username: ");
      String username = input.nextLine();
      System.out.print("Enter password: ");
      String password = input.nextLine();
      System.out.print("Enter user's role: ");
      String role = input.nextLine();
      System.out.print("Enter user's name: ");
      String name = input.nextLine();
      System.out.print("Enter user's phone: ");
      String phone = input.nextLine();
      System.out.print("Enter user's address: ");
      String address = input.nextLine();
      System.out.print("Enter user's credit card number: ");
      String creditCard = input.nextLine();
      
      System.out.println("\n User info: \n - Username: " + username + "\n - Password: " + password + "\n - Name: " + name + "\n - Address: " + address + "\n - Credit card: " + creditCard );
      String userId = "U00" + count;
      String userDataLine =  userId + "/" + username + "/" + password + "/" + role + "/" + name + "/" + phone + "/" + address + "/" + creditCard + "\n";

      myWriter.write(userDataLine);
      count += 1;

      System.out.println("\nContinue input user data? \n [1] Yes  [2] No ");

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
