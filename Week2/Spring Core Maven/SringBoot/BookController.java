/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.library.api.controller;
import com.library.api.entity.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.library.api.entity.Book;
import com.library.api.services.IBookService;

@RestController
@RequestMapping("api/books")
/**
 *
 * @author Ashwithaa
 */
public class BookController {
    @Autowired
	IBookService bookService;
	
@GetMapping("/test")
public String test()
{
	return "Welcome to Book API";
}

@PostMapping("/add")
public BookController addBook(@RequestBody BookController book)
{
	return bookService.save(book);
}
@PutMapping("/edit")
public Book updateBook(@RequestBody BookController book)
{
	return bookService.update(book);
}
@GetMapping("/list")
public List<Book> getAllBooks()
{
	List<Book> books=bookService.findAll();
	return books;
}
@GetMapping("/{id}")
public Book getBook(@PathVariable int id)
{
	Book book=bookService.findById(id);
	return book;
}
@DeleteMapping("/delete/{id}")
public String getBookDelete(@PathVariable int id)
{
	return bookService.deleteById(id);
	
}
}
