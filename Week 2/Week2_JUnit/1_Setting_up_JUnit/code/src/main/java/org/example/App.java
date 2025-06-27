package org.example;

public class App {
    public String getMessage() {
        return "Hello, World!"; // This is the correct return value
    }
    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.getMessage());
    }
}
