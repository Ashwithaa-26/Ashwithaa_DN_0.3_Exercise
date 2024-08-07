/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.observerpattern;
 
/**
 *
 * @author Ashwithaa
 */
public class ObserverPattern {

    public static void main(String[] args) {
StockMarket stockMarket = new StockMarket();

        Observer mobileApp1 = new MobileApp("MobileApp1");
        Observer mobileApp2 = new MobileApp("MobileApp2");
        Observer webApp = new WebApp("WebApp");

        stockMarket.registerObserver(mobileApp1);
        stockMarket.registerObserver(mobileApp2);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice(100.00);
        stockMarket.setStockPrice(105.50);

        stockMarket.deregisterObserver(mobileApp1);

        stockMarket.setStockPrice(110.75);    }
}
