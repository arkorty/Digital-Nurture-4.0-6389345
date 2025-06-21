import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("B002", "To Kill a Mockingbird", "Harper Lee"),
            new Book("B003", "1984", "George Orwell"),
            new Book("B004", "Pride and Prejudice", "Jane Austen"),
            new Book("B005", "The Catcher in the Rye", "J.D. Salinger")
        };
        System.out.println("Linear Search:");
        String searchTitleLinear = "1984";
        Book foundBookLinear = Search.linearSearch(books, searchTitleLinear);
        System.out.println("Searching for: '" + searchTitleLinear + "'");
        if (foundBookLinear != null) {
            System.out.println("Found: " + foundBookLinear);
        } else {
            System.out.println("Not found.");
        }
        Arrays.sort(books);
        System.out.println("\nBinary Search:");
        System.out.println("Sorted books:");
        for (Book book : books) {
            System.out.println(book);
        }
        String searchTitleBinary = "The Great Gatsby";
        Book foundBookBinary = Search.binarySearch(books, searchTitleBinary);
        System.out.println("\nSearching for: '" + searchTitleBinary + "'");
        if (foundBookBinary != null) {
            System.out.println("Found: " + foundBookBinary);
        } else {
            System.out.println("Not found.");
        }
    }
} 
