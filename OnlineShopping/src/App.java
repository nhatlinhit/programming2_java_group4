import java.util.ArrayList;
import java.util.Scanner;

public class App {
  static ArrayList<Cart> cartList = new ArrayList<Cart>();
  public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      showWelcomeStatement(input);

      input.close();
  }

  static void showWelcomeStatement(Scanner input) {
      System.out.println("============ Shopping Online System - Group 4 =============== ");
      System.out.println("Welcome, customer! ");
      System.out.println("[1] Browse products");
      System.out.println("[2] Login");
      System.out.println("[3] Register account");
      System.out.println("[4] View cart");
      System.out.print("Choose action [_]: ");
      // customer input action
      int action = input.nextInt();

      switch (action) {
        case 1:
          System.out.println("\n ======= Products ====== \n");
          showListProduct(input);
          break;
        case 2:
          System.out.println("\n ======== Login ======== \n");
          break;
        case 3:
          System.out.println("\n ======== Register ======= \n");
          break;
        case 4:
          System.out.println("\n ========= Cart ======== \n");
          viewCart();
          break;
        default:
          System.out.println("\n ======= Products ====== \n");
          showListProduct(input);
      }
  }

  static void showListProduct(Scanner input) {
    ReadProductData productData = new ReadProductData();
    ArrayList<Product> products = productData.readData();
    System.out.println("[1] Add product to cart");
    System.out.println("[2] Back");
    System.out.print("Choose action [_]: ");
    int action = input.nextInt();
    if (action == 1) {
      addToCart(input, products);
    } else {
      showWelcomeStatement(input);
    }
  }

  static void login(Scanner input) {
    ReadUserData userData = new ReadUserData();
    ArrayList<User> users = userData.readUserData();
    System.out.print("Enter username: ");
    String username = input.nextLine();
    System.out.print("Enter password: ");
    String password = input.nextLine();

    for ( User u: users) {
      ///
    }
    // for (int i = 0; i < users.size(); i++) {
    //   User us = new User
    // }
  }

  static void addToCart(Scanner input, ArrayList<Product> products) {
    boolean continueAddToCart = true;
    do {
      System.out.print("Choose product [_] add to cart: ");
      int prodNum = input.nextInt();
      int index = prodNum-1;
      Product item = products.get(index);

      System.out.print("Enter quantity of ["+ item.getName() +"] add to cart: ");
      int qty = input.nextInt();

      Cart cartItem = new Cart(item, qty);
      cartList.add(cartItem);

      System.out.println("\nContinue add product to cart? \n [1] Yes  [2] No ");
      int isContinue = input.nextInt();

      if (isContinue == 2) {
        continueAddToCart = false;
        showWelcomeStatement(input);
      }
    } while(continueAddToCart);
  }

  static void viewCart() {
    int num = 1;
    for (Cart item : cartList) {
      System.out.println("------ Cart Item ["+ num +"] -------");
      System.out.println(item);
      System.out.println();
      num++;
    }
  }

}