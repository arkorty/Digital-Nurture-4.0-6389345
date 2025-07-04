package com.library.Service;

import com.library.model.Librarian;
import com.library.Repository.BookRepository;

/**
 * Service class demonstrating both constructor and setter injection.
 */
public class BookService {

    private final BookRepository bookRepository; // Injected via constructor
    private Librarian librarian;                 // Injected via setter

    /**
     * Constructor for mandatory dependencies.
     * @param bookRepository The repository instance, injected by Spring.
     */
    public BookService(BookRepository bookRepository) {
        System.out.println("BookService constructor called: Injecting BookRepository.");
        this.bookRepository = bookRepository;
    }

    /**
     * Setter for optional dependencies.
     * @param librarian The librarian instance, injected by Spring.
     */
    public void setLibrarian(Librarian librarian) {
        System.out.println("BookService setter called: Injecting Librarian.");
        this.librarian = librarian;
    }

    /**
     * Uses the injected dependencies to perform a business operation.
     * @param bookId The ID of the book to get details for.
     */
    public void getBookDetails(int bookId) {
        System.out.println("Service layer: Attempting to get book details...");
        String bookDetails = bookRepository.findBookById(bookId);
        System.out.println(bookDetails);

        if (librarian != null) {
            System.out.println("Request handled by: " + librarian.getName());
        } else {
            System.out.println("No librarian is assigned to this service.");
        }
    }
}
