public class Main {
    public static void main(String[] args) {
        // Create the stock market
        StockMarket stockMarket = new StockMarket("GOOGL", 1500.00);

        // Create observers
        Observer mobileApp = new MobileApp("MobileApp1");
        Observer webApp = new WebApp("WebApp1");

        // Register observers
        stockMarket.register(mobileApp);
        stockMarket.register(webApp);

        // Change the stock price and notify observers
        System.out.println("Changing stock price...");
        stockMarket.setPrice(1550.50);

        System.out.println("\nDeregistering mobile app and changing price again...");
        // Deregister an observer
        stockMarket.deregister(mobileApp);

        // Change the stock price again
        stockMarket.setPrice(1600.75);
    }
} 
