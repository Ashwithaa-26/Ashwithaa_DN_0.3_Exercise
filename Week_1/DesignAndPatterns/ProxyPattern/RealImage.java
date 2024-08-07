/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proxypattern;

/**
 *
 * @author Ashwithaa
 */
public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromServer();
    }

    private void loadImageFromServer() {
        System.out.println("Loading " + filename + " from remote server...");
        // Simulate a delay for loading image from server
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Image " + filename + " loaded.");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
    
}
