
public class Cart {
    private int qty;
    private Product product;

    public Cart(Product product, int qty) {
      this.product = product;
      this.qty = qty;
    }

    @Override
    public String toString() {
      return " - ID: " + product.getProductId() + "\n - Name: " + product.getName() + "\n - Quantity: " + qty;
    }
}
