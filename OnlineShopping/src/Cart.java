
public class Cart {
    private int qty;
    private Product product;

    public Cart(Product product, int qty) {
      this.product = product;
      this.qty = qty;
    }

    public double getItemAmount(){
      return product.getPrice() * qty;
    }

    public Product getProduct() {
      return product;
    }

    public int getQty() {
      return qty;
    }

    public void setQty(int qty) {
      this.qty = qty;
    }

    @Override
    public String toString() {
      return "\n  - Product ID: #" + product.getProductId() + "\n  - Name: " + product.getName() + "\n  - Quantity: " + qty + "\n  - Amount: " + getItemAmount() + "\n";
    }
}
