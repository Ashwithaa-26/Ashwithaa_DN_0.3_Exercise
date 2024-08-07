/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.builderpatternexample;

/**
 *
 * @author Ashwithaa
 */
public class BuilderPatternExample {

    public static void main(String[] args) {
 Computer gamingPC = new Computer.Builder()
                .setCPU("Intel Core i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 3090")
                .setMotherboard("ASUS ROG")
                .setPowerSupply("850W")
                .setCaseType("Full Tower")
                .build();

        // Office Workstation
        Computer officePC = new Computer.Builder()
                .setCPU("Intel Core i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setGPU("Integrated")
                .setMotherboard("Gigabyte")
                .setPowerSupply("500W")
                .setCaseType("Mid Tower")
                .build();

        // Print the configurations
        System.out.println(gamingPC);
        System.out.println(officePC);
    }
}
