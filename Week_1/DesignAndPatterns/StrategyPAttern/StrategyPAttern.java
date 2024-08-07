/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.strategypattern;

/**
 *
 * @author Ashwithaa 
 */
public class StrategyPAttern {

    public static void main(String[] args) {
PaymentContext context = new PaymentContext();

        // Paying with Credit Card
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234567890123456", "John Doe", "123", "12/25");
        context.setPaymentStrategy(creditCardPayment);
        context.executePayment(100.00);

        // Paying with PayPal
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com", "securepassword");
        context.setPaymentStrategy(payPalPayment);
        context.executePayment(200.00);    }
}
