/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.library.repository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ashwithaa
 */
@Repository
public class BookRepository {
      public void findAll() {
        System.out.println("Fetching all books from the repository...");
    }
}
