
package JAVA;

import java.util.Scanner;

class BookNotFoundException extends Exception {
    public BookNotFoundException(String msg) {
        super(msg);
    }
}

class Book {
    String title;
    boolean checkedout;

    public Book(String title, boolean checkedout) {
        this.title = title;
        this.checkedout = checkedout;
    }
}

class Library {
    Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

    public Book findBook(String title) throws BookNotFoundException {
        for (Book book : books) {
            if (book.title.trim().equalsIgnoreCase(title.trim())) {
                return book;
            }
        }
        throw new BookNotFoundException("Book '" + title + "' not found in the library.");
    }

    public void searchBook(String title) {
        try {
            Book b = findBook(title);
            String status;
            if (b.checkedout) {
                status = "Checked Out";
            } else {
                status = "Available";
            }
            System.out.println("Book found: " + b.title + " [" + status + "]");
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void checkoutBook(String title) {
        try {
            Book b = findBook(title);
            if (b.checkedout) {
                System.out.println("Sorry, '" + b.title + "' is already checked out.");
            } else {
                b.checkedout = true;
                System.out.println("You have successfully checked out '" + b.title + "'.");
            }
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void returnBook(String title) {
        try {
            Book b = findBook(title);
            if (!b.checkedout) {
                System.out.println("This book was not checked out.");
            } else {
                b.checkedout = false;
                System.out.println("You have successfully returned '" + b.title + "'.");
            }
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book[] books = {
                new Book("Java", false),
                new Book("Python", false),
                new Book("C++", true)
        };

        Library lib = new Library(books);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Library System ---");
            System.out.println("1. Search Book");
            System.out.println("2. Checkout Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 4) {
                exit = true;
                continue;
            }

            System.out.print("Enter book title: ");
            String title = sc.nextLine();

            switch (choice) {
                case 1:
                    lib.searchBook(title);
                    break;
                case 2:
                    lib.checkoutBook(title);
                    break;
                case 3:
                    lib.returnBook(title);
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
                    break;
            }
        }
        sc.close();
    }
}
