/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author melihaltin
 */
public class Currency {
    private String name;
    private double amount;
    private double currentPrice;

        public Currency(String name, double amount, double currentPrice) {
        this.name = name;
        this.amount = amount;
        this.currentPrice = currentPrice;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getTotalValue() {
        return amount * currentPrice;
    }
}