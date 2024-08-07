/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adapterpatternex;

/**
 *
 * @author Ashwithaa
 */
public class PayPalAdapter implements PaymentProcessor {
    private PayPAl payPal;

    public PayPalAdapter(PayPAl payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.makePayment(amount);
    }
}
