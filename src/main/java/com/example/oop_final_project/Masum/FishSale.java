package com.example.oop_final_project.Masum;

import java.io.Serializable;
import java.time.LocalDate;

public class FishSale implements Serializable {
    private String fishName, area;
    private double pricePerKg, soldAmount, profit;
    private LocalDate date;

    public FishSale(String fishName, String area, double pricePerKg, double soldAmount, double profit, LocalDate date) {
        this.fishName = fishName;
        this.area = area;
        this.pricePerKg = pricePerKg;
        this.soldAmount = soldAmount;
        this.profit = profit;
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

    public double getSoldAmount() {
        return soldAmount;
    }

    public void setSoldAmount(double soldAmount) {
        this.soldAmount = soldAmount;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
