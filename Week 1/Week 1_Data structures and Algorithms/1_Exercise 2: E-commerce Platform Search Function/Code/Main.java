import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(203, "Smartphone", "Electronics"),
                new Product(305, "Desk Chair", "Furniture"),
                new Product(412, "Coffee Maker", "Appliances"),
                new Product(520, "Headphones", "Electronics")
        };

        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, Comparator.comparingInt(Product::getProductId));

        System.out.println("Linear Search:");
        long startTime = System.nanoTime();
        Product foundLinear = SearchAlgorithms.linearSearch(products, 305);
        long endTime = System.nanoTime();
        System.out.println("Found: " + foundLinear);
        System.out.println("Time: " + (endTime - startTime) + " ns");

        System.out.println("\nBinary Search:");
        startTime = System.nanoTime();
        Product foundBinary = SearchAlgorithms.binarySearch(sortedProducts, 305);
        endTime = System.nanoTime();
        System.out.println("Found: " + foundBinary);
        System.out.println("Time: " + (endTime - startTime) + " ns");

        System.out.println("\nPerformance Comparison:");
        compareSearchPerformance(1000);
        compareSearchPerformance(10000);
        compareSearchPerformance(100000);
    }

    private static void compareSearchPerformance(int size) {
        Product[] largeProducts = new Product[size];
        for (int i = 0; i < size; i++) {
            largeProducts[i] = new Product(i, "Product " + i, "Category " + (i % 10));
        }

        Product[] sortedLargeProducts = Arrays.copyOf(largeProducts, largeProducts.length);
        Arrays.sort(sortedLargeProducts, Comparator.comparingInt(Product::getProductId));

        int targetId = size / 2;

        System.out.println("\n" + size + " products:");

        long start = System.nanoTime();
        SearchAlgorithms.linearSearch(largeProducts, targetId);
        long end = System.nanoTime();
        System.out.println("Linear search: " + (end - start) + " ns");

        start = System.nanoTime();
        SearchAlgorithms.binarySearch(sortedLargeProducts, targetId);
        end = System.nanoTime();
        System.out.println("Binary search: " + (end - start) + " ns");
    }
}
