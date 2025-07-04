package com.library.Repository;

/**
 * Repository class to handle data access for books.
 */
public class BookRepository {
    public String findBookById(int bookId) {
        return "Fetching book with ID: " + bookId + " from the database.";
    }
}
