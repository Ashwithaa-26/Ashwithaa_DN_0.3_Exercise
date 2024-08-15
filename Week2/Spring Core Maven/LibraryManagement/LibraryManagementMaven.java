package com.mycompany.librarymanagementmaven;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementMaven{
    public static void main(String[] args) {
    // Load the Spring context from the XML configuration file
 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the BookService bean and use it
        BookService bookService = (BookService) context.getBean("bookService");
       // bookService.listBooks();

}

}