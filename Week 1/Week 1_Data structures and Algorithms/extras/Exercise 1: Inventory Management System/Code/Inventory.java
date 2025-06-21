import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    // Add a product
    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
        System.out.println("Added: " + product);
    }

    // Update a product
    public void updateProduct(String productId, int newQuantity, double newPrice) {
        Product product = products.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
            System.out.println("Updated: " + product);
        } else {
            System.out.println(productId + " not found.");
        }
    }

    // Delete a product
    public void deleteProduct(String productId) {
        if (products.remove(productId) != null) {
            System.out.println("Deleted: " + productId);
        } else {
            System.out.println(productId + " not found.");
        }
    }
    
    // Get product
    public Product getProduct(String productId) {
        return products.get(productId);
    }

    // Display all products
    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory:");
            for (Product product : products.values()) {
                System.out.println(product);
            }
        }
    }
} 
