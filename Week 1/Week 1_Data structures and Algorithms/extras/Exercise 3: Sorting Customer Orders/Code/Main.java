import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("O001", "Alice", 250.50),
            new Order("O002", "Bob", 150.75),
            new Order("O003", "Charlie", 300.00),
            new Order("O004", "David", 100.25),
            new Order("O005", "Eve", 200.00)
        };
        System.out.println("Original orders:");
        printOrders(orders);
        Order[] ordersForBubble = Arrays.copyOf(orders, orders.length);
        Sort.bubbleSort(ordersForBubble);
        System.out.println("\nSorted by Bubble Sort:");
        printOrders(ordersForBubble);
        Order[] ordersForQuick = Arrays.copyOf(orders, orders.length);
        Sort.quickSort(ordersForQuick, 0, ordersForQuick.length - 1);
        System.out.println("\nSorted by Quick Sort:");
        printOrders(ordersForQuick);
    }
    public static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
} 
