import java.util.Scanner;

public class User {
  private String userId;
  private String username;
  private String password;
  private String role;
  private String name;
  private String phone;
  private String address;
  private String creditcard;
  

  public User(String userId, String username, String password, String role, String name, String phone, String address, String creditcard) {
    this.userId = userId;
    this.username = username;
    this.password = password;
    this.role = role;
    this.name = name;
    this.phone = phone;
    this.address = address;
    this.creditcard = creditcard;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
      this.username = username;
  }

  public String getPassword() {
      return password;
  }

 public void setPassword(String password) {
    this.password = password;
 }

 public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public void registerAccount() {
      Scanner input = new Scanner(System.in);
      System.out.println("===== Register new account ===== ");
      System.out.print("Enter username: ");
      String username = input.nextLine();
      System.out.print("Enter password: ");
      String password = input.nextLine();
      System.out.print("Enter user's name: ");
      String name = input.nextLine();
      System.out.print("Enter user's phone: ");
      String phone = input.nextLine();
      System.out.print("Enter user's address: ");
      String address = input.nextLine();
      System.out.print("Enter user's credit card number: ");
      String creditCard = input.nextLine();

      final String role = "user";
  }

  @Override
  public String toString() {
     return "User{" + "userId=" + userId + "username=" + username + "role=" + role + ", name=" + name + ", phone=" + phone + ", address=" + address + ", creditcard=" + creditcard + '}';
  }
}
