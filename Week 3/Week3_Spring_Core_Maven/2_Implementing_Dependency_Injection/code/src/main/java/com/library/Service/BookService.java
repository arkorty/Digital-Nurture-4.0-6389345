package com.library.Service;

import com.library.Repository.BookRepository;

/**
 * Service class to handle business logic related to books.
 * This class depends on BookRepository to fetch book data.
 */
public class BookService {

    private BookRepository bookRepository;

    /**
     * Default constructor.
     */
    public BookService() {
    }

    /**
     * Setter method for dependency injection.
     * The Spring container will call this method to inject an instance of BookRepository.
     * The method must be public and follow the set<PropertyName> convention.
     * @param bookRepository The repository for accessing book data.
     */
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    /**
     * A method that uses the repository to get book details.
     * @param bookId The ID of the book to retrieve.
     */
    public void getBookDetails(int bookId) {
        System.out.println("Service layer: Getting book details...");
        // Ensure bookRepository is not null before using it
        if (bookRepository != null) {
            String bookDetails = bookRepository.findBookById(bookId);
            System.out.println(bookDetails);
        } else {
            System.out.println("Error: BookRepository has not been set.");
        }
    }
}
