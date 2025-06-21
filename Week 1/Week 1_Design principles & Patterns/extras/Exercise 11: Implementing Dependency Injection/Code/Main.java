public class Main {
    public static void main(String[] args) {
        // Create the repository instance
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the repository into the service
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the service to find a customer
        System.out.println("Finding customer with ID 123...");
        String customer = customerService.getCustomer("123");
        System.out.println("Customer: " + customer);

        System.out.println("\nFinding customer with ID 456...");
        customer = customerService.getCustomer("456");
        System.out.println("Customer: " + customer);
    }
} 
