/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ashwithaa
 */
package com.mycompany.bookcustomermanagement.assembler;

import com.mycompany.bookcustomermanagement.controller.BookController;
import com.mycompany.bookcustomermanagement.Book;
import com.mycompany.bookcustomermanagement.model.BookModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class BookModelAssembler extends RepresentationModelAssemblerSupport<Book, BookModel> {

    public BookModelAssembler() {
        super(BookController.class, BookModel.class);
    }

    @Override
    public BookModel toModel(Book book) {
        BookModel bookModel = new BookModel(book);
        bookModel.add(linkTo(methodOn(BookController.class).getBookById(book.getId())).withSelfRel());
        bookModel.add(linkTo(methodOn(BookController.class).getAllBooks()).withRel("books"));
        return bookModel;
    }

    @Override
    public CollectionModel<BookModel> toCollectionModel(Iterable<? extends Book> entities) {
        CollectionModel<BookModel> bookModels = super.toCollectionModel(entities);
        bookModels.add(linkTo(methodOn(BookController.class).getAllBooks()).withSelfRel());
        return bookModels;
    }
}

