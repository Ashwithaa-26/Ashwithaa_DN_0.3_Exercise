/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ecommercemanagement;

/**
 *     
 * @author Ashwithaa
 */

import java.util.List;

public class EcommerceManagement {

    public static void main(String[] args) {
        Search platform = new Search();

        platform.addProduct(new Product("001", "iPhone 12", "Electronics"));
        platform.addProduct(new Product("002", "Samsung Galaxy S21", "Electronics"));
        platform.addProduct(new Product("003", "MacBook Pro", "Electronics"));
        platform.addProduct(new Product("004", "Dell XPS 13", "Electronics"));

        // Linear Search
        List<Product> foundProducts = platform.linearSearchByName("MacBook Pro");
        for (Product product : foundProducts) {
            System.out.println("Linear Search found: " + product.getProductName() + " in category " + product.getCategory());
        }

        // Binary Search (assuming the list is sorted)
        foundProducts = platform.binarySearchByName("iPhone 12");
        for (Product product : foundProducts) {
            System.out.println("Binary Search found: " + product.getProductName() + " in category " + product.getCategory());
        }
    }
}
