package com.example.oop_final_project.Fahim;

import java.time.LocalDate;

public class TrackStock {
    private String itemName;
    private String category;
    private float currentQuantity;
    private LocalDate lastUpdated;
    private String sortStock;

    public TrackStock(String itemName, String category, float currentQuantity, LocalDate lastUpdated, String sortStock) {
        this.itemName = itemName;
        this.category = category;
        this.currentQuantity = currentQuantity;
        this.lastUpdated = lastUpdated;
        this.sortStock = sortStock;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(float currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getSortStock() {
        return sortStock;
    }

    public void setSortStock(String sortStock) {
        this.sortStock = sortStock;
    }

    @Override
    public String toString() {
        return "TrackStock{" +
                "itemName='" + itemName + '\'' +
                ", category='" + category + '\'' +
                ", currentQuantity=" + currentQuantity +
                ", lastUpdated=" + lastUpdated +
                ", sortStock='" + sortStock + '\'' +
                '}';
    }
}
