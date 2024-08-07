/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.employeemanagement;

/**
 *
 * @author Ashwithaa
 */

import java.util.ArrayList;  
import java.util.List;

public class EmployeeManagement {
public static void main(String[] args) {
         EmployeeManagementSys management = new EmployeeManagementSys(10);

        // Adding employees
        management.addEmployee(new Employee("E001", "Alice", "Manager", 80000));
        management.addEmployee(new Employee("E002", "Bob", "Developer", 60000));
        management.addEmployee(new Employee("E003", "Charlie", "Analyst", 70000));

        // Traversing employees
        System.out.println("All Employees:");
        management.traverseEmployees();

        // Searching for an employee
        System.out.println("\nSearching for Employee with ID E002:");
        Employee emp = management.searchEmployee("E002");
        if (emp != null) {
            System.out.println(emp);
        } else {
            System.out.println("Employee not found");
        }

        // Deleting an employee
        System.out.println("\nDeleting Employee with ID E002:");
        boolean deleted = management.deleteEmployee("E002");
        if (deleted) {
            System.out.println("Employee deleted successfully");
        } else {
            System.out.println("Employee not found");
        }

        // Traversing employees after deletion
        System.out.println("\nAll Employees after deletion:");
        management.traverseEmployees();
    }
}
