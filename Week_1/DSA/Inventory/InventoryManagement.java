/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.inventorymanagement;

/**
 *
 * @author Ashwithaa
 */
import java.util.HashMap;
public class InventoryManagement {
  private HashMap<String, Product> products;

    public InventoryManagement() {
        this.products = new HashMap<>();
    }

    public Product getProduct(String productId) {
        return products.get(productId);
    }
    public void addProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            System.out.println("Product ID already exists. Use updateProduct to modify the existing product.");
        } else {
            products.put(product.getProductId(), product);
            System.out.println("Product added successfully.");
        }
    }

    // Method to update an existing product in the inventory
    public void updateProduct(String productId, Product updatedProduct) {
        if (products.containsKey(productId)) {
            products.put(productId, updatedProduct);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product ID not found. Use addProduct to add a new product.");
        }
    }

    // Method to delete a product from the inventory
    public void deleteProduct(String productId) {
        if (products.containsKey(productId)) {
            products.remove(productId);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product ID not found.");
        }
    }
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        Product product1 = new Product("001", "Product 1", 10, 100.0);
        Product product2 = new Product("002", "Product 2", 20, 200.0);

        inventory.addProduct(product1);
        inventory.addProduct(product2);

        inventory.addProduct(product1);

        Product updatedProduct1 = new Product("001", "Updated Product 1", 15, 150.0);
        inventory.updateProduct("001", updatedProduct1);

        inventory.updateProduct("003", updatedProduct1);

        inventory.deleteProduct("001");

        inventory.deleteProduct("003");
    }

}
