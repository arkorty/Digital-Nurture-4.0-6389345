public class Main {
    public static void main(String[] args) {
        SinglyLinkedList taskList = new SinglyLinkedList();
        taskList.addTask(new Task("T001", "Design database schema", "In Progress"));
        taskList.addTask(new Task("T002", "Develop API endpoints", "Not Started"));
        taskList.addTask(new Task("T003", "Create UI mockups", "Completed"));
        System.out.println("Traversing tasks:");
        taskList.traverseTasks();
        System.out.println("\nSearching for T002:");
        Task found = taskList.searchTask("T002");
        System.out.println("Found: " + found);
        System.out.println("\nDeleting T003:");
        taskList.deleteTask("T003");
        System.out.println("\nTraversing after deletion:");
        taskList.traverseTasks();
    }
} 
