/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.library.api.services;

/**
 *
 * @author Ashwithaa
 */
import com.library.api.controller.BookController;
import java.util.List;

import com.library.api.entity.Book;



public interface IBookService {

public List<Book> findAll();
	
	public Book findById(int theId);
	
	public Book save(Book theBook);
	
	public String deleteById(int theId);
	
	public Book update(BookController theBook);

    public BookController save(BookController book);
}
