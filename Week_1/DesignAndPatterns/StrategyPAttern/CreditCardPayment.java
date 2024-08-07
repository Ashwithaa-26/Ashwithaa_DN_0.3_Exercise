/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.strategypattern;

/**
 *
 * @author Ashwithaa
 */
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String cvv;
    private String expirationDate;

    public CreditCardPayment(String cardNumber, String cardHolderName, String cvv, String expirationDate) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
        // Implementation for processing credit card payment
    }
}
