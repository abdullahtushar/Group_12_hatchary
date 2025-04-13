package com.example.oop_final_project.Masum;

public class FishData {
    private String fishName;
    private double pricePerkg;

    public String getFishName() {
        return fishName;
    }

    public void setFishName(String fishName) {
        this.fishName = fishName;
    }

    public double getPricePerkg() {
        return pricePerkg;
    }

    public void setPricePerkg(double pricePerkg) {
        this.pricePerkg = pricePerkg;
    }

    @Override
    public String toString() {
        return "FishData{" +
                "fishName='" + fishName + '\'' +
                ", pricePerkg=" + pricePerkg +
                '}';
    }
}
