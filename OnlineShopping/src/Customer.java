public class Customer {
   private String customerId;
   private String username;
   private String name;
   private String address;
   private String creditcard;
   private String password;

  public Customer(String customerId, String username, String password, String name, String address, String creditcard) {
      this.customerId = customerId;
      this.username = username;
      this.name = name;
      this.address = address;
      this.creditcard = creditcard;
      this.password = password;
  }

  public String getUsername() {
     return username;
  }

  public void setUsername(String username) {
     this.username = username;
  }

  public String getName() {
     return name;
  }

  public void setName(String name) {
     this.name = name;
  }

  public String getAddress() {
     return address;
  }

  public void setAddress(String address) {
     this.address = address;
  }

  public String getCreditcard() {
     return creditcard;
  }

  public void setCreditcard(String creditcard) {
     this.creditcard = creditcard;
  }

  public String getPassword() {
     return password;
  }

  public void setPassword(String password) {
     this.password = password;
  }

  @Override
  public String toString() {
     return "Customer{" + "username=" + username + ", name=" + name + ", address=" + address + ", creditcard=" + creditcard + ", password=" + password + '}';
  }
}