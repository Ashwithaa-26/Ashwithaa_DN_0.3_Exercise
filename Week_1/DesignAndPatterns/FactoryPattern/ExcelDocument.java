/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.factorypattern;

/**
 *
 * @author Ashwithaa
 */
public class ExcelDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening Excel document...");
    }

    @Override
    public void save() {
        System.out.println("Saving Excel document...");
    }

    @Override
    public void close() {
        System.out.println("Closing Excel document...");
    }
}
