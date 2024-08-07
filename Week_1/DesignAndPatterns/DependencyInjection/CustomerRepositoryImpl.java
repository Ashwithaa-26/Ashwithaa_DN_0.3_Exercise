/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dependencyinjection;

/**
 *
 * @author Ashwithaa
 */
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(String id) {
        // In a real application, this would query a database
        return new Customer(id, "John Doe", "john.doe@example.com");
    }
}

