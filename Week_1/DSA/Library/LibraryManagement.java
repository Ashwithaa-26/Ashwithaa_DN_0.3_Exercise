/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.librarymanagement;

/**
 *
 * @author Ashwithaa
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LibraryManagement {

     private List<Books> books;

    public LibraryManagement() {
        this.books = new ArrayList<>();
    }

    public void addBook(Books book) {
        books.add(book);
        // Sort books after adding a new one to maintain order
        Collections.sort(books, Comparator.comparing(Books::getTitle, String.CASE_INSENSITIVE_ORDER));
    }
    public List<Books> linearSearchByTitle(String title) {
        List<Books> foundBooks = new ArrayList<>();
        for (Books book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }
    public List<Books> binarySearchByTitle(String title) {
        List<Books> foundBooks = new ArrayList<>();
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Books midBook = books.get(mid);
            int comparison = midBook.getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                // If the exact title is found, add the book and search for duplicates around it
                foundBooks.add(midBook);
                int leftIndex = mid - 1;
                while (leftIndex >= 0 && books.get(leftIndex).getTitle().equalsIgnoreCase(title)) {
                    foundBooks.add(books.get(leftIndex));
                    leftIndex--;
                }
                int rightIndex = mid + 1;
                while (rightIndex < books.size() && books.get(rightIndex).getTitle().equalsIgnoreCase(title)) {
                    foundBooks.add(books.get(rightIndex));
                    rightIndex++;
                }
                break;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return foundBooks;
    }

    public List<Books> getBooks() {
        return books;
    }

    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();

        library.addBook(new Books("001", "Harry Potter and the Philosopher's Stone", "J.K. Rowling"));
        library.addBook(new Books("002", "Harry Potter and the Chamber of Secrets", "J.K. Rowling"));
        library.addBook(new Books("003", "The Hobbit", "J.R.R. Tolkien"));

        // Linear Search
        List<Books> foundBooks = library.linearSearchByTitle("The Hobbit");
        for (Books book : foundBooks) {
            System.out.println("Linear Search found: " + book.getTitle() + " by " + book.getAuthor());
        }
    
        // Binary Search (assuming the list is sorted)
        foundBooks = library.binarySearchByTitle("Harry Potter and the Chamber of Secrets");
        for (Books book : foundBooks) {
            System.out.println("Binary Search found: " + book.getTitle() + " by " + book.getAuthor());
        }
    }
}
