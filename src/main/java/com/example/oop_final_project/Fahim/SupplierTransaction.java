package com.example.oop_final_project.Fahim;

import java.time.LocalDate;

public class SupplierTransaction {

    private String supplierName;
    private LocalDate date;
    private String itemOrdered;
    private int quantity;
    private double cost;

    public SupplierTransaction(String supplierName, LocalDate date, String itemOrdered, int quantity, double cost) {
        this.supplierName = supplierName;
        this.date = date;
        this.itemOrdered = itemOrdered;
        this.quantity = quantity;
        this.cost = cost;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getItemOrdered() {
        return itemOrdered;
    }

    public void setItemOrdered(String itemOrdered) {
        this.itemOrdered = itemOrdered;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "SupplierTransaction{" +
                "supplierName='" + supplierName + '\'' +
                ", date=" + date +
                ", itemOrdered='" + itemOrdered + '\'' +
                ", quantity=" + quantity +
                ", cost=" + cost +
                '}';
    }
}
