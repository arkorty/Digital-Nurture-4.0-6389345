package com.library;

import com.library.Service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main class to run the Spring application.
 */
public class MainApp {

    public static void main(String[] args) {
        // Load the Spring configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean
        BookService bookService = (BookService) context.getBean("bookService");

        // Test the application
        bookService.getBookDetails(201);

        // Close the context
        ((ClassPathXmlApplicationContext) context).close();
    }
}
