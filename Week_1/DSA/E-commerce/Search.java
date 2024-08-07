/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecommercemanagement;

/**
 *
 * @author Ashwithaa
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator; 
import java.util.List;

public class Search {
     private List<Product> products;

    public Search() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        Collections.sort(products, Comparator.comparing(Product::getProductName, String.CASE_INSENSITIVE_ORDER));
    }

    public List<Product> linearSearchByName(String productName) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public List<Product> binarySearchByName(String productName) {
        List<Product> foundProducts = new ArrayList<>();
        int left = 0;
        int right = products.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Product midProduct = products.get(mid);
            int comparison = midProduct.getProductName().compareToIgnoreCase(productName);

            if (comparison == 0) {
                // If the exact name is found, add the product and search for duplicates around it
                foundProducts.add(midProduct);
                int leftIndex = mid - 1;
                while (leftIndex >= 0 && products.get(leftIndex).getProductName().equalsIgnoreCase(productName)) {
                    foundProducts.add(products.get(leftIndex));
                    leftIndex--;
                }
                int rightIndex = mid + 1;
                while (rightIndex < products.size() && products.get(rightIndex).getProductName().equalsIgnoreCase(productName)) {
                    foundProducts.add(products.get(rightIndex));
                    rightIndex++;
                }
                break;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return foundProducts;
    }

    public List<Product> getProducts() {
        return products;
    }
}
