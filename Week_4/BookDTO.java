/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ashwithaa
 */
package com.mycompany.bookstore.dto;

import lombok.Data;

@Data
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private Double price;
    private String isbn;
    
      @JsonGetter("bookTitle")
    public String getTitle() {
        return title;
    }

    @JsonSetter("bookTitle")
    public void setTitle(String title) {
        this.title = title;
    }
}
