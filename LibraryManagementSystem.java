
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

public class LibraryManagementSystem {

    public static void main(String[] args) {

        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.println("Enter quantity: ");
                    int quantity;
                    try {
                        quantity = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid quantity. Please enter a number.");
                        break;
                    }
                    library.addBook(title, author, quantity);
                    break;

                case 2:
                    System.out.println("Enter book title: ");
                    title = scanner.nextLine();
                    System.out.println("Enter borrow quantity: ");
                    try {
                        quantity = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid quantity. Please enter a number.");
                        break;
                    }
                    library.borrowBook(title, quantity);
                    break;

                case 3:
                    System.out.println("Enter book title: ");
                    title = scanner.nextLine();
                    System.out.println("Enter borrow quantity: ");
                    try {
                        quantity = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid quantity. Please enter a number.");
                        break;
                    }
                    library.returnBook(title, quantity);
                    break;

                case 4:
                    library.exit();
                    break;

                default:
                    System.out.println("Invalid choice. Please choose a number between 1 and 4.");
            }

        }

    }

}