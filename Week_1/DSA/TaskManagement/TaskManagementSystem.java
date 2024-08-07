/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.taskmanagementsystem;

/**
 *
 * @author Ashwithaa
 */
public class TaskManagementSystem {
    public static void main(String[] args) { 
        TaskManagement management = new TaskManagement();

        // Adding tasks
        management.addTask(new Task("T001", "Design Database", "Pending"));
        management.addTask(new Task("T002", "Implement API", "In Progress"));
        management.addTask(new Task("T003", "Setup CI/CD", "Pending"));

        // Traversing tasks
        System.out.println("All Tasks:");
        management.traverseTasks();

        // Searching for a task
        System.out.println("\nSearching for Task with ID T002:");
        Task task = management.searchTask("T002");
        if (task != null) {
            System.out.println(task);
        } else {
            System.out.println("Task not found");
        }

        // Deleting a task
        System.out.println("\nDeleting Task with ID T002:");
        boolean deleted = management.deleteTask("T002");
        if (deleted) {
            System.out.println("Task deleted successfully");
        } else {
            System.out.println("Task not found");
        }

        // Traversing tasks after deletion
        System.out.println("\nAll Tasks after deletion:");
        management.traverseTasks();
    }
    }

