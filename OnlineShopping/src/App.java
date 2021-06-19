import java.util.Scanner;

public class App {
  public static void main(String[] args) {
      System.out.println("===== Shopping Online System ===== ");
      System.out.println("Welcome, customer! ");
      Scanner input = new Scanner(System.in);
      System.out.println("[1] Browse products");
      System.out.println("[2] Login");
      System.out.println("[3] Register account");
      System.out.print("Enter number of action you want to do: ");
      int action = input.nextInt();

      switch (action) {
        case 1:
          System.out.println("===== Customer ====");
          break;
        case 2:
          System.out.println("===== Login ====");
          break;
        case 3:
          System.out.println("===== Register ====");
          break;
        default:
          System.out.println("===== Products ====");
      }
  }

}