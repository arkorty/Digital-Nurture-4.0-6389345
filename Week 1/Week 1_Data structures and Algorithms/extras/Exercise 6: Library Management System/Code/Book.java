public class Book implements Comparable<Book> {
    private String bookId;
    private String title;
    private String author;
    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
    public String getBookId() {
        return bookId;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    @Override
    public String toString() {
        return "ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }
} 
