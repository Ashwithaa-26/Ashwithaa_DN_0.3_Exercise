package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public void findAll() {
        System.out.println("Fetching all books from the repository...");
        // Simulate fetching data from a database
    }
}
