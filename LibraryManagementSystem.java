
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Library class to manage books in the library
class Library {

    // HashMap to store book title as the key and Book object as the value
    private Map<String, Book> books;

    // Constructor to initialize the books HashMap
    public Library() {
        books = new HashMap<>();
    }

    // Method to add a new book or update an existing book's quantity
    public void addBook(String title, String author, int quantity) {
        // Check if the book already exists in the library
        if (books.containsKey(title)) {
            // Update the quantity of the existing book
            books.get(title).increseQuantity(quantity);
            System.err.println("You've successfully updated the quantity of existing book");
        } else {
            // Add a new book to the library if it doesn't exist
            books.put(title, new Book(title, author, quantity));
            System.out.println("You've added new book to the Library");
        }

    }

    // Method to borrow books from the library
    public void borrowBook(String title, int quantity) {
        // Check if the book is available in the library
        if (books.containsKey(title)) {
            // Check if enough copies are available to borrow
            Book book = books.get(title);
            if (book.getQuantity() >= quantity) {
                // Reduce the quantity of the book by the borrowed amount
                book.decreseQuantity(quantity);
                System.out.println("You've borrowed " + quantity + " copies of '" + title + "'.");
            } else {
                // Error message if not enough copies are available
                System.out.println("Error: Not enough copies available to borrow.");
            }

        } else {
            // Error message if the book is not found in the library
            System.out.println("Error: Book not available in the library.");
        }
    }

    // Method to return books to the library
    public void returnBook(String title, int quantity) {
        // Check if the returned book exists in the library
        if (books.containsKey(title)) {
            // Increase the quantity of the book by the returned amount
            books.get(title).increseQuantity(quantity);
            System.out.println("You have successfully returned " + quantity + " copies of '" + title + "'.");
        } else {
            // Error message if the book is not part of the library's collection
            System.out.println("Error: This book does not belong to the library.");
        }
    }

    // Method to exit the program
    public void exit() {
        System.out.println("Exiting the system. Goodbye!");
        // Terminate the program
        System.exit(0);
    }

}

// Book class to represent individual books in the libraryyyy
class Book {
    // Title of the book
    public String title;
    // Author of the book
    public String author;
    // Quantity of books available
    public int quantity;

    // Constructor to initialize the book's title, author, and quantity
    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    // Get method to get the current quantity of the book
    public int getQuantity() {
        return quantity;
    }

    // Method to increase the quantity of the book
    public void increseQuantity(int amount) {
        quantity += amount;
    }

    // Method to decrease the quantity of the book
    public void decreseQuantity(int amount) {
        quantity -= amount;
    }
}

// Main class to run the Library Management System
public class LibraryManagementSystem {

    public static void main(String[] args) {

        // Create an instance of the Library class
        Library library = new Library();
        // Scanner to take user input
        Scanner scanner = new Scanner(System.in);

        // Infinite loop to continuously prompt the user for actions
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            // Variable to store the user's choice
            int choice;
            try {
                // Get user input for the menu choice
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Handle invalid input that is not an integer
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                // Go back to the start of the loop
                continue;
            }

            // Switch case to handle user input
            switch (choice) {
                // Add Books
                case 1:
                    System.out.println("Enter book title: ");
                    // Get the book title
                    String title = scanner.nextLine();
                    System.out.println("Enter author: ");
                    // Get the author name
                    String author = scanner.nextLine();
                    System.out.println("Enter quantity: ");
                    int quantity;
                    try {
                        // Get the quantity to add
                        quantity = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        // Handle invalid input for quantity
                        System.out.println("Invalid quantity. Please enter a number.");
                        break;
                    }
                    // Add or update the book in the library
                    library.addBook(title, author, quantity);
                    break;

                // Borrow Books
                case 2:
                    System.out.println("Enter book title: ");
                    // Get the book title
                    title = scanner.nextLine();
                    System.out.println("Enter borrow quantity: ");
                    try {
                        // Get the quantity to borrow
                        quantity = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        // Handle invalid input for quantity
                        System.out.println("Invalid quantity. Please enter a number.");
                        break;
                    }
                    // Borrow the book from the library
                    library.borrowBook(title, quantity);
                    break;

                // Return Books
                case 3:
                    System.out.println("Enter book title: ");
                    // Get the book title
                    title = scanner.nextLine();
                    System.out.println("Enter borrow quantity: ");
                    try {
                        // Get the quantity to borrow
                        quantity = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        // Handle invalid input for quantity
                        System.out.println("Invalid quantity. Please enter a number.");
                        break;
                    }
                    // Return the book to the library
                    library.returnBook(title, quantity);
                    break;

                // Exit the program
                case 4:
                    // Call the exit method to end the program
                    library.exit();
                    break;

                default:
                    System.out.println("Invalid choice. Please choose a number between 1 and 4.");
            }

        }

    }

}