package com.library;

import com.library.Service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp {

    public static void main(String[] args) {
        System.out.println("Loading Spring Application Context...");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("Spring Context loaded successfully.");
        BookService bookService = (BookService) context.getBean("bookService");

        System.out.println("Retrieved 'bookService' bean from the container.");
        bookService.getBookDetails(303);
        context.close();
    }
}
