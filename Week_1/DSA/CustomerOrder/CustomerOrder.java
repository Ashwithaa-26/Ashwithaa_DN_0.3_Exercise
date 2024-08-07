/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.customerorder;

/**
 *
 * @author Ashwithaa
 */
import java.util.ArrayList;
import java.util.List;
public class CustomerOrder {
 public static void main(String[] args) {
        OrderManagement  orderManagement = new OrderManagement();

        List<Order> orders = new ArrayList<>();
        orders.add(new Order("001", "Alice", 150.00));
        orders.add(new Order("002", "Bob", 300.00));
        orders.add(new Order("003", "Charlie", 120.00));
        orders.add(new Order("004", "David", 450.00));
        orders.add(new Order("005", "Eve", 200.00));

        System.out.println("Original Orders:");
        printOrders(orders);

        // Bubble Sort
        orderManagement.bubbleSort(orders);
        System.out.println("\nOrders sorted by Bubble Sort:");
        printOrders(orders);

        // Shuffling the list for Quick Sort example
        orders.clear();
        orders.add(new Order("001", "Alice", 150.00));
        orders.add(new Order("002", "Bob", 300.00));
        orders.add(new Order("003", "Charlie", 120.00));
        orders.add(new Order("004", "David", 450.00));
        orders.add(new Order("005", "Eve", 200.00));

        // Quick Sort
        orderManagement.quickSort(orders, 0, orders.size() - 1);
        System.out.println("\nOrders sorted by Quick Sort:");
        printOrders(orders);
    }

    private static void printOrders(List<Order> orders) {
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getOrderId() + ", Customer Name: " + order.getCustomerName() + ", Total Price: " + order.getTotalPrice());
        }
    }
}
