**Library Management System**

Project Overview:

A simple Java-based Library Management System that allows users to:
-Add books to the library.
-Borrow available books.
-Return borrowed books.
-View all available books.

Features
-Add Book: Add new books to the library with unique ISBN, title, author, and publication year.
-Borrow Book: Borrow a book if it's available.
-Return Book: Return a borrowed book and update its availability.
-View Available Books: View a list of all available books in the library.

Note: For the sake of simplicity, actual ISBNs are not considered in this project.

**Follow the steps for running on local machine:**
  1.Clone the Repository:
      git clone https://github.com/atharv-1410/Library-Management-System.git
      cd Library-Management-System/src/main/java

  2.Compile the Project:
      javac Library.java Book.java

  3.Run the Application:
      java Library


 Example Commands:
	
 Library Menu:
1. Add Book
2. Borrow Book
3. Return Book
4. View Available Books
5. Exit

Enter your choice: 1
Enter ISBN: 
12345
Enter Title: 
Library Manage
Enter Author: 
Atharv Deshpande
Enter Publication Year: 
2002
Output: Book added successfully!

Enter your choice: 4
Output: List of available books...
