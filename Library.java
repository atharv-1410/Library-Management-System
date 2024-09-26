import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        //Checks for duplicate ISBN before adding the book
        for (Book b : books) {
            if (b.getIsbn().equals(book.getIsbn())) {
                System.out.println("A book with the same ISBN already exists.");
                return; // Exit if duplicate found
            }
        }
        books.add(book);
        System.out.println("Book added successfully.\n");
    }

    public void borrowBook(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            System.out.println("Enter a valid ISBN.\n");//ISBN validation check
            return;
        }
        //checks if the ISBN entered is found in the available books
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && book.isAvailable()) {
                book.borrowBook();
                System.out.println("Book borrowed successfully.\n");
                return;
            }
        }
        System.out.println("Book is either not available or already borrowed.\n");
    }

    public void returnBook(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            System.out.println("Enter a valid ISBN.\n");
            return;
        }

        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (!book.isAvailable()) { //Checks if the book is borrowed before returning it
                    book.returnBook();
                    System.out.println("Book returned successfully.\n");
                } else {
                    System.out.println("Book was not borrowed.\n");
                }
                return;
            }
        }
        System.out.println("Invalid ISBN.\n");
    }

    public void viewAvailableBooks() {
        System.out.printf("%-20s %-30s %-20s %-15s%n", "ISBN", "Title", "Author", "Year");
        System.out.println("--------------------------------------------------------------");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.printf("%-20s %-30s %-20s %-15d%n",
                        book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublicationYear());
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        //Menu
        while (true) {
            System.out.println("Library Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. View Available Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();  

                switch (choice) {
                    case 1:
                        System.out.println("Enter ISBN:");
                        String isbn = scanner.nextLine();
                        if (isbn == null || isbn.trim().isEmpty()) {
                            System.out.println("Enter a valid ISBN.\n");
                            break;
                        }

                        System.out.println("Enter Title:");
                        String title = scanner.nextLine();
                        if (title == null || title.trim().isEmpty()) {
                            System.out.println("Enter a valid title.\n");
                            break;
                        }

                        System.out.println("Enter Author:");
                        String author = scanner.nextLine();
                        if (author == null || author.trim().isEmpty()) {
                            System.out.println("Enter a valid author.\n");
                            break;
                        }

                        System.out.println("Enter Publication Year:");
                        String yearInput = scanner.nextLine();
                        if (yearInput == null || yearInput.trim().isEmpty()) {
                            System.out.println("Enter a valid publication year.\n");
                            break;
                        }

                        int year;//Exception Handling when any non integer year is entered
                        try {
                            year = Integer.parseInt(yearInput);
                            if (year <= 0) {
                                System.out.println("Enter a valid publication year greater than 0.\n");
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Enter a valid integer for the publication year.\n");
                            break;
                        }

                        //Creates a new book object
                        Book book = new Book(isbn, title, author, year);
                        library.addBook(book); 
                        break;

                    case 2:
                        System.out.println("Enter ISBN to borrow:");
                        isbn = scanner.nextLine();
                        library.borrowBook(isbn);
                        break;

                    case 3:
                        System.out.println("Enter ISBN to return:");
                        isbn = scanner.nextLine();
                        library.returnBook(isbn);
                        break;

                    case 4:
                        library.viewAvailableBooks();
                        break;

                    case 5:
                        System.out.println("Exiting...\n");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Enter a valid choice.\n");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.\n");//Handling when any non integer input is given
                scanner.nextLine(); 
            }
        }
    }
}
