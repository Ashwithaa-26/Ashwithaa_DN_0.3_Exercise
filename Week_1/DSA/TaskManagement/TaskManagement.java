/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanagementsystem;

/**
 *
 * @author Ashwithaa
 */
public class TaskManagement {
     private Node head;

    private static class Node {
        Task task;
        Node next;

        Node(Task task) { 
            this.task = task;
            this.next = null;
        }
    }

    // Add a new task at the end
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Search for a task by ID
    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null; // Task not found
    }

    // Traverse all tasks
    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete a task by ID
    public boolean deleteTask(String taskId) {
        if (head == null) {
            return false; 
        }
        if (head.task.getTaskId().equals(taskId)) {
            head = head.next; 
            return true;
        }
        Node current = head;
        while (current.next != null && !current.next.task.getTaskId().equals(taskId)) {
            current = current.next;
        }
        if (current.next == null) {
            return false; 
        }
        current.next = current.next.next; 
        return true;
    }
}
