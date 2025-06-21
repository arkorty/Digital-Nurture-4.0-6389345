public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(String id) {
        // In a real application, this would access a database.
        // For this example, we'll return a dummy customer.
        if ("123".equals(id)) {
            return "John Doe";
        }
        return "Customer Not Found";
    }
} 
