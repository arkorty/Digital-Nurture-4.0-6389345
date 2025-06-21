public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Product p1 = new Product("P001", "Laptop", 50, 1200.00);
        Product p2 = new Product("P002", "Mouse", 200, 25.00);
        Product p3 = new Product("P003", "Keyboard", 150, 45.00);
        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);
        inventory.displayProducts();
        System.out.println("\nUpdating P002:");
        inventory.updateProduct("P002", 180, 24.50);
        inventory.displayProducts();
        System.out.println("\nDeleting P003:");
        inventory.deleteProduct("P003");
        inventory.displayProducts();
    }
} 
