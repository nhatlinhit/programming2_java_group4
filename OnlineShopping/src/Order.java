import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class Order {
   enum OrderStatus {
      CREATED,
      PAID,
      CONFIRMED,
      CANCELLED
    }

  private User user;
  private List<Cart> cartItems = new ArrayList<>(); // Sample for storage Products data 
  private Date orderDate = new Date();
  private String orderID;
  private OrderStatus status;

  public Order(User user) {
     this.user = user;
     this.status = OrderStatus.CREATED;
  }

  public User getUser() {
     return user;
  }

  public void setUser(User user) {
     this.user = user;
  }

  public Date getOrderDate() {
     return orderDate;
  }

  public void setOrderDate(Date orderDate) {
     this.orderDate = orderDate;
  }

  public List<Cart> getCartItems() {
     return cartItems;
  }

  public void setCartItems(List<Cart> cartItems) {
     this.cartItems = cartItems;
  }

  public String getOrderID() {
     return orderID;
  }

  public OrderStatus getOrderStatus() {
   return status;
}

  public void setOrderID(String orderID) {
     this.orderID = orderID;
  }

  public void payment() {
     this.status = OrderStatus.PAID;
  }

   public void adminConfirm() {
      this.status = OrderStatus.CONFIRMED;
   }

   public void cancelOrder() {
      this.status = OrderStatus.CANCELLED;
   }
  
  public double getTotal(){
     double total = 0;
  
     // loop through cart items
       // for each
     for(Cart cart : cartItems){
        total = total + cart.getItemAmount();
     }
         // call getItemTotal, and add to total
     return total;
  }
  
  public String getCurrencyTotal() {
     NumberFormat df = DecimalFormat.getCurrencyInstance();
     return df.format(getTotal());
  }
  
  public void addItem(Cart item){
     cartItems.add(item);
  }

  @Override
  public String toString() {
     return "\n - Order ID: #" + getOrderID() + "\n - Order Date: " + orderDate + "\n - Order status: " + status + "\n - User's name: " + getUser().getName()  + "\n Items: " + cartItems + "\n - Total: " + getTotal() + '\n';
  }
  
}