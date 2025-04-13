package com.example.oop_final_project.Masum;

public class FishStock {
    private String fishId;
    private String fishName;
    private double pricePerKg;

    public String getFishId() {
        return fishId;
    }

    public void setFishId(String fishId) {
        this.fishId = fishId;
    }

    public String getFishName() {
        return fishName;
    }

    public void setFishName(String fishName) {
        this.fishName = fishName;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(double pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    @Override
    public String toString() {
        return "FishStock{" +
                "fishId='" + fishId + '\'' +
                ", fishName='" + fishName + '\'' +
                ", pricePerKg=" + pricePerKg +
                '}';
    }
}
