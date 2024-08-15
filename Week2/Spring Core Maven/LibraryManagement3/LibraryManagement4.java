package com.mycompany.librarymanagement4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagement4 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the bean
        BookService bookService = (BookService) context.getBean("bookServiceWithSetter");
        bookService.listBooks();
    }
}
