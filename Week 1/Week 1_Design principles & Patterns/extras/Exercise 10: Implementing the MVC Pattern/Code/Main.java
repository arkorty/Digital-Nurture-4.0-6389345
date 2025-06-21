public class Main {
    public static void main(String[] args) {
        // Create a model
        Student model = new Student("1", "John Doe", "A");

        // Create a view
        StudentView view = new StudentView();

        // Create a controller
        StudentController controller = new StudentController(model, view);

        // Display initial details
        System.out.println("Initial student details:");
        controller.updateView();

        System.out.println("\nUpdating student details...");
        // Update model data
        controller.setStudentName("Jane Doe");
        controller.setStudentGrade("A+");

        // Display updated details
        System.out.println("\nUpdated student details:");
        controller.updateView();
    }
} 
