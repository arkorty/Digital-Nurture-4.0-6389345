package com.library.Service;

import com.library.Repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;
    public BookService() {
    }
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("Setter method called: Injecting BookRepository.");
        this.bookRepository = bookRepository;
    }
    public void getBookDetails(int bookId) {
        System.out.println("Service layer: Attempting to get book details...");
        if (bookRepository != null) {
            String bookDetails = bookRepository.findBookById(bookId);
            System.out.println(bookDetails);
        } else {
            System.out.println("Error: BookRepository dependency was not injected.");
        }
    }
}
