package com.example.oop_final_project.Masum;

import java.time.LocalDate;

public class FishSaleSummary {
    private String fishName, area;
    private double pricePerKg, totalSalesAmount, totalCost;
    private LocalDate date;

    public FishSaleSummary(String fishName, double pricePerKg, String area, double totalSalesAmount, double totalCost, LocalDate date) {
        this.fishName = fishName;
        this.pricePerKg = pricePerKg;
        this.area = area;
        this.totalSalesAmount = totalSalesAmount;
        this.totalCost = totalCost;
        this.date = date;
    }

    public String getFishName() {
        return fishName;
    }

    public void setFishName(String fishName) {
        this.fishName = fishName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(double pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public double getTotalSalesAmount() {
        return totalSalesAmount;
    }

    public void setTotalSalesAmount(double totalSalesAmount) {
        this.totalSalesAmount = totalSalesAmount;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void addSale(double amount, double cost) {
        this.totalSalesAmount += amount;
        this.totalCost += cost;
    }
}
