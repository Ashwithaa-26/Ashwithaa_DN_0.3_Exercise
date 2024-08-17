/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.library.api.repository;

/**
 *
 * @author Ashwithaa
 */
import com.library.api.controller.BookController;
import org.springframework.data.jpa.repository.JpaRepository;

import com.library.api.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

    public Book save(BookController theBook);

}
