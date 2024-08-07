/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.financialmanagementsystem;

/**
 * 
 * @author Ashwithaa
 */
public class FinancialManagementSystem {

 public double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base case: If no more years to calculate, return the present value
        if (years == 0) {
            return presentValue;
        } else {
            // Recursive case: Calculate future value for (years - 1) and apply growth rate
            return calculateFutureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
        }
    }

    public static void main(String[] args) {
        FinancialManagementSystem forecast = new FinancialManagementSystem();

        // Example usage
        double presentValue = 1000.0; // Initial value
        double growthRate = 0.05; // 5% annual growth rate
        int years = 10; // Number of years

        double futureValue = forecast.calculateFutureValue(presentValue, growthRate, years);
        System.out.println("Future Value after " + years + " years: " + futureValue);
    }
}
