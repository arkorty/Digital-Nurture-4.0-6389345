public class Main {
    public static void main(String[] args) {
        EmployeeManagement ems = new EmployeeManagement(5);
        ems.addEmployee(new Employee("E001", "Alice", "Developer", 75000));
        ems.addEmployee(new Employee("E002", "Bob", "Manager", 90000));
        ems.addEmployee(new Employee("E003", "Charlie", "Analyst", 60000));
        System.out.println("Traversing employees:");
        ems.traverseEmployees();
        System.out.println("\nSearching for E002:");
        Employee found = ems.searchEmployee("E002");
        System.out.println("Found: " + found);
        System.out.println("\nDeleting E003:");
        ems.deleteEmployee("E003");
        System.out.println("\nTraversing after deletion:");
        ems.traverseEmployees();
    }
} 
