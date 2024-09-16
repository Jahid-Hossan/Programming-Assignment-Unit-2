
/**
 * library
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Library {

    private Map<String, Book> books;

    public Library() {
        books = new HashMap<>();
    }

    public void addBook(String title, String author, int quantity) {

        if (books.containsKey(title)) {
            books.get(title).increseQuantity(quantity);
            System.err.println("You've successfully updated the quantity of existing book");
        } else {
            books.put(title, new Book(title, author, quantity));
            System.out.println("You've added new book to the Library");
        }

    }

    public void borrowBook(String title, int quantity) {

        if (books.containsKey(title)) {

            Book book = books.get(title);
            if (book.getQuantity() >= quantity) {
                book.decreseQuantity(quantity);
                System.out.println("You've borrowed " + quantity + " copies of '" + title + "'.");
            } else {
                System.out.println("Error: Not enough copies available to borrow.");
            }

        } else {
            System.out.println("Error: Book not available in the library.");
        }
    }

    public void returnBook(String title, int quantity) {
        if (books.containsKey(title)) {

            books.get(title).increseQuantity(quantity);
            System.out.println("You have successfully returned " + quantity + " copies of '" + title + "'.");

        } else {
            System.out.println("Error: This book does not belong to the library.");
        }
    }

    public void exit() {
        System.out.println("Exiting the system. Goodbye!");
        System.exit(0);
    }

}

class Book {

    public String title;
    public String author;
    public int quantity;

    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increseQuantity(int amount) {
        quantity += amount;
    }

    public void decreseQuantity(int amount) {
        quantity -= amount;
    }
}
