package onlineShoppingSystem;

public interface Cart {
    void addProduct(Product product, int quantity);
    void removeProduct(Product product);
    void viewCart();
}
