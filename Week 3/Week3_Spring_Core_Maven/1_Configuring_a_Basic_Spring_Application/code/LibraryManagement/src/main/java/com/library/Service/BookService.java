package com.library.Service;

import com.library.Repository.BookRepository;


public class BookService {

    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void getBookDetails(int bookId) {
        System.out.println("Service layer: Getting book details...");
        String bookDetails = bookRepository.findBookById(bookId);
        System.out.println(bookDetails);
    }
}
