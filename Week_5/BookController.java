///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//
///**
// *
// * @author Ashwithaa
// */
//package com.mycompany.bookcustomermanagement.controller;
//
//import com.mycompany.bookcustomermanagement.Book;
//import com.mycompany.bookcustomermanagement.service.BookService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/books")
//public class BookController {
//
//    @Autowired
//    private BookService bookService;
//
//     @Autowired
//    private BookModelAssembler bookModelAssembler;
//     
//   // @PostMapping
////    public ResponseEntity<Book> createBook(@Validated @RequestBody Book book) {
////        Book createdBook = bookService.createBook(book);
////        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
////    }
////
////    @GetMapping
////    public ResponseEntity<List<Book>> getAllBooks() {
////        List<Book> books = bookService.getAllBooks();
////        return new ResponseEntity<>(books, HttpStatus.OK);
////    }
////
////    @GetMapping("/{id}")
////    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
////        Optional<Book> book = bookService.getBookById(id);
////        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
////                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
////    }
////
////    @PutMapping("/{id}")
////    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Validated @RequestBody Book book) {
////        if (!bookService.getBookById(id).isPresent()) {
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////        }
////        book.setId(id);
////        Book updatedBook = bookService.updateBook(book);
////        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
////    }
////
////    @DeleteMapping("/{id}")
////    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
////        if (!bookService.getBookById(id).isPresent()) {
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////        }
////        bookService.deleteBook(id);
////        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
////    }
////         @GetMapping
////    public CollectionModel<BookModel> getAllBooks() {
////        List<Book> books = bookService.getAllBooks();
////        return bookModelAssembler.toCollectionModel(books);
////    }
////
////    @GetMapping("/{id}")
////    public BookModel getBookById(@PathVariable Long id) {
////        Book book = bookService.getBookById(id);
////        return bookModelAssembler.toModel(book);
////    }
////
////    @PostMapping
////    public ResponseEntity<BookModel> createBook(@Valid @RequestBody Book book) {
////        Book savedBook = bookService.saveBook(book);
////        BookModel bookModel = bookModelAssembler.toModel(savedBook);
////        return ResponseEntity.created(bookModel.getRequiredLink("self").toUri()).body(bookModel);
////    }
////
////    @PutMapping("/{id}")
////    public ResponseEntity<BookModel> updateBook(@PathVariable Long id, @Valid @RequestBody Book bookDetails) {
////        Book updatedBook = bookService.updateBook(id, bookDetails);
////        BookModel bookModel = bookModelAssembler.toModel(updatedBook);
////        return ResponseEntity.ok(bookModel);
////    }
////
////    @DeleteMapping("/{id}")
////    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
////        bookService.deleteBook(id);
////        return ResponseEntity.noContent().build();
////    }
//       @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public ResponseEntity<List<Book>> getAllBooks() {
//        List<Book> books = bookService.getAllBooks();
//        return ResponseEntity.ok(books);
//    }
//
//    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
//        Book book = bookService.getBookById(id);
//        if (book != null) {
//            return ResponseEntity.ok(book);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//                 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public ResponseEntity<Book> createBook(@RequestBody Book book) {
//        Book savedBook = bookService.saveBook(book);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
//    }
//
//    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//                produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
//        Book updatedBook = bookService.updateBook(id, bookDetails);
//        return ResponseEntity.ok(updatedBook);
//    }
//
//    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
//        bookService.deleteBook(id);
//        return ResponseEntity.noContent().build();
//    }
//}

package com.mycompany.bookcustomermanagement.controller;

import com.mycompany.bookcustomermanagement.entity.Book;
import com.mycompany.bookcustomermanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/books")
@Schema(name = "Book", description = "Book API")
public class BookController {

    @Autowired
    private BookService bookService;

    @Operation(summary = "Create a new book", description = "Add a new book to the inventory")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Book created"),
        @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<Book> createBook(
            @RequestBody @Parameter(description = "Book details") Book book) {
        Book createdBook = bookService.saveBook(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @Operation(summary = "Get a book by ID", description = "Retrieve a book by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Book found"),
        @ApiResponse(responseCode = "404", description = "Book not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(
            @PathVariable @Parameter(description = "Book ID") Long id) {
        Book book = bookService.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @Operation(summary = "Update a book", description = "Update details of an existing book")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Book updated"),
        @ApiResponse(responseCode = "404", description = "Book not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(
            @PathVariable @Parameter(description = "Book ID") Long id,
            @RequestBody @Parameter(description = "Updated book details") Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @Operation(summary = "Delete a book", description = "Remove a book from the inventory")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Book deleted"),
        @ApiResponse(responseCode = "404", description = "Book not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(
            @PathVariable @Parameter(description = "Book ID") Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
