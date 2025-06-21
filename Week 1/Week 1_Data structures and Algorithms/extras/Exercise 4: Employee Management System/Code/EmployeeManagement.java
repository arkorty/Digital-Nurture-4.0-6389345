import java.util.Arrays;
public class EmployeeManagement {
    private Employee[] employees;
    private int size;
    public EmployeeManagement(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }
    public boolean addEmployee(Employee employee) {
        if (size >= employees.length) {
            System.out.println("Cannot add more employees.");
            return false;
        }
        employees[size++] = employee;
        System.out.println("Added: " + employee);
        return true;
    }
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }
    public void traverseEmployees() {
        if (size == 0) {
            System.out.println("No employees.");
            return;
        }
        System.out.println("Employees:");
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }
    public boolean deleteEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[size - 1] = null;
                size--;
                System.out.println("Deleted: " + employeeId);
                return true;
            }
        }
        System.out.println(employeeId + " not found.");
        return false;
    }
} 
