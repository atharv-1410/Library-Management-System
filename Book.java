public class Book {
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private boolean isAvailable;
//Validation for all the fields entered by the user 
    public Book(String isbn, String title, String author, int publicationYear) {
        // Check for null or empty values for all required fields
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("Enter a valid ISBN.");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Enter a valid title.");
        }
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Enter a valid author.");
        }
        if (publicationYear <= 0) {
            throw new IllegalArgumentException("Enter a valid publication year.");
        }

        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = true; 
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }
    public boolean isAvailable() { return isAvailable; }

    public void borrowBook() {//Checks if book is already borrowed. If yes, it can't be re borrowed unless returned by the previous borrower
        if (isAvailable) {
            isAvailable = false;
        } else {
            System.out.println("Book is already borrowed.");
        }
    }

    public void returnBook() {
        isAvailable = true;
    }
}
