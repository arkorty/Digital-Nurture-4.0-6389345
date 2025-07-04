package com.library.Repository;


public class BookRepository {

    public String findBookById(int bookId) {

        return "Fetching book with ID: " + bookId + " from the library database.";
    }
}
