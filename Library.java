
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
