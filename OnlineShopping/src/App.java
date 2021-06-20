import java.util.ArrayList;
import java.util.Scanner;

public class App {
  static ArrayList<Cart> cartList = new ArrayList<Cart>();
  static Order currentOrder;
  static boolean isLogin = false;
  static boolean isAdmin = false;
  static User loggedUser;
  public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("\n ============ Shopping Online System - Group 4 =============== \n");

      showWelcomeStatement();

      input.close();
  }

  static void showWelcomeStatement() {
      Scanner input = new Scanner(System.in);
      if (isLogin) { // Show home to user logged in
        showWelcomeUserStatement();
      } else {
        System.out.println("Welcome, customer! \n");
        System.out.println("[1] View products");
        System.out.println("[2] Login");
        System.out.println("[3] Register account");
        System.out.println("[4] View cart");
        System.out.print("\n Choose action [_]: ");
        // customer input action
        int action = input.nextInt();

        switch (action) {
          case 1:
            System.out.println("\n========== Products ============ \n");
            showListProduct();
            break;
          case 2:
            System.out.println("\n======== Login ======== \n");
            login();
            break;
          case 3:
            System.out.println("\n======== Register ======= \n");
            break;
          case 4:
            System.out.println("\n========= Cart ======== \n");
            viewCart();
            break;
          default:
            System.out.println("\n======= Products ====== \n");
            showListProduct();
        }
      }
  }

  static void showWelcomeUserStatement() {
    Scanner input = new Scanner(System.in);
    System.out.println("Welcome, "+loggedUser.getName()+"! \n");
    System.out.println("[1] View products");
    System.out.println("[2] View cart");
    System.out.println("[3] Log out");
    System.out.print("\n Choose action [_]: ");
    // customer input action
    int action = input.nextInt();

    switch (action) {
      case 1:
        System.out.println("\n========== Products ============ \n");
        showListProduct();
        break;
      case 2:
        System.out.println("\n========= Cart ======== \n");
        viewCart();
        break;
      case 3:
        logout();
        break;
      default:
        System.out.println("\n======= Products ====== \n");
        showListProduct();
    }
}

  static void showListProduct() {
    Scanner input = new Scanner(System.in);
    ReadProductData productData = new ReadProductData();
    ArrayList<Product> products = productData.readData();
    System.out.println("[1] Add product to cart");
    System.out.println("[2] Back to home");
    System.out.print("\n Choose action [_]: ");
    int action = input.nextInt();
    if (action == 1) {
      addToCart(input, products);
    } else {
      System.out.println("\n-----------------------------------\n");
      showWelcomeStatement();
    }
  }

  static void login() {
    Scanner input = new Scanner(System.in);
    ReadUserData userData = new ReadUserData();
    ArrayList<User> users = userData.readUserData();
    System.out.print("Enter username: ");
    String username = input.nextLine();
    System.out.print("Enter password: ");
    String password = input.nextLine();
    
    for ( User user: users) {
      if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
        isLogin = true;
        loggedUser = user;
        // Check admin
        if (user.getRole() == "admin") { 
          isAdmin = true;
        }
        System.out.println("\n >>> Login success! <<<");
        System.out.println("\n-----------------------------------\n");
        showWelcomeStatement();
      }
    }

    if (!isLogin) {
      System.out.println("\n >>> Login fail! <<<\n");
      System.out.println("[1] Try again?");
      System.out.println("[2] Back to home");
      System.out.print("\n Choose action [_]: ");
      int action = input.nextInt();
      if (action == 1) {
        System.out.println("\n======== Login ======== \n");
        login();
      } else {
        System.out.println("\n-----------------------------------\n");
        showWelcomeStatement();
      }
    }
  }

  static void logout() {
    isLogin = false;
    System.out.println("\n-----------------------------------\n");
    showWelcomeStatement();
  }

  static void addToCart(Scanner input, ArrayList<Product> products) {
    boolean continueAddToCart = true;
    do {
      System.out.print("Choose product [_] add to cart: ");
      int prodNum = input.nextInt();
      int index = prodNum-1;
      Product item = products.get(index);

      System.out.print("How many "+ item.getName() +" add to cart: ");
      int qty = input.nextInt();
      
      // Check exist in cart
      boolean existItem = false;
      for (int i = 0; i < cartList.size(); i++) {
        Product cartProd = cartList.get(i).getProduct();
        if (cartProd.equals(item)) {
          existItem = true;
          // update cart item with new quantity
          Cart cartItem = cartList.get(i);
          int newQty = qty + cartItem.getQty();
          cartItem.setQty(newQty);  
          cartList.set(i, cartItem);
        }
      }

      if (!existItem) {
        Cart cartItem = new Cart(item, qty);
        cartList.add(cartItem);
      }

      System.out.println("\nContinue add product to cart? \n [1] Yes  [2] Check out  [3] Back to home ");
      int isContinue = input.nextInt();

      if (isContinue > 1) {
        continueAddToCart = false;
        System.out.println("\n-----------------------------------\n");
        if( isContinue == 2 ) {
          checkout();
        } else {
          showWelcomeStatement();
        }
      }
    } while(continueAddToCart);
  }

  static void viewCart() {
    int num = 1;
    Scanner input = new Scanner(System.in);
    if (cartList.size() > 0) {
      for (Cart item : cartList) {
        System.out.println("------ Cart Item ["+ num +"] -------");
        System.out.println(item);
        System.out.println();
        num++;
      }
      System.out.println("[1] View products");
      System.out.println("[2] Check out");
      System.out.println("[3] Back to home");
      System.out.print("\n Choose action [_]: ");
      int action = input.nextInt();
      switch (action) {
        case 1:
          showListProduct();
          break;
        case 2:
          checkout();
          break;
        case 3:
          showWelcomeStatement();
          break;
        default:
          showListProduct();
      }
    } else {
      System.out.println("Cart is empty!!! \n");
      System.out.println("[1] View products");
      System.out.println("[2] Back to home");
      System.out.print("\n Choose action [_]: ");
      int action = input.nextInt();
      if(action == 1) {
        showListProduct();
      } else {
        System.out.println("\n-----------------------------------\n");
        showWelcomeStatement();
      }
    }
  }

  static void checkout() {
    Scanner input = new Scanner(System.in);
    if (isLogin) {
      Order newOrder = new Order(loggedUser);
      newOrder.setCartItems(cartList);
      int randomNum = (int) (Math.random() * (9999 - 1)) + 1; // Create random ID
      newOrder.setOrderID("OD"+randomNum);
      currentOrder = newOrder;

      // Clear cart
      cartList = new ArrayList<Cart>();

      System.out.println("\n=========== Order ==============");
      System.out.println(newOrder);
      System.out.println();

      System.out.println("[1] Payment \t [2] Cancel");
      System.out.print("\n Choose action [_]: ");
      int action = input.nextInt();

      if (action == 1) {
        currentOrder.payment();
        System.out.println("\n Payment successful amount "+ currentOrder.getTotal() +" for order #"+currentOrder.getOrderID()+". \n");
        System.out.println("\n=========== Order ==============");
        System.out.println(currentOrder);
        System.out.println("\n---------------------------\n");
        showWelcomeStatement();
      } else {
        currentOrder.cancelOrder();
        System.out.println("\n Order #"+currentOrder.getOrderID()+" is cancelled!\n");
        System.out.println("\n=========== Order ==============");
        System.out.println(currentOrder);
        System.out.println("\n---------------------------\n");
        showWelcomeStatement();
      }

    } else {
      System.out.println("\nYou have not logged in yet!\n");
      System.out.println("[1] Login");
      System.out.println("[2] Back to home");
      System.out.print("\n Choose action [_]: ");
      int action = input.nextInt();
      if(action == 1) {
        System.out.println("\n======== Login ======== \n");
        login();
      } else {
        System.out.println("\n-----------------------------------\n");
        showWelcomeStatement();
      }
    }
  }

}