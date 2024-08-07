/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.singleton;

/**
 *
 * @author Ashwithaa
 */
public class Logger {
        private static Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {
        // Initialize the logger, e.g., set up log file, log level, etc.
        System.out.println("Logger initialized");
    }

    // Public method to provide access to the instance
    public static Logger getInstance() {
        if (instance == null) {
            // Create a new instance if it doesn't exist
            instance = new Logger();
        }
        return instance;
    }

    // Example logging method
    public void log(String message) {
        System.out.println("Log: " + message);
    } 
}
