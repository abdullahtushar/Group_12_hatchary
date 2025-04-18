package com.example.oop_final_project.Fahim;

import java.time.LocalDate;

public class TrackStock {
    private String itemName;
    private String category;
    private float currentQuantity;
    private LocalDate lastUpdated;
    private Integer reorderThreshold;

    public TrackStock(String itemName, String category, float currentQuantity, LocalDate lastUpdated, Integer reorderThreshold) {
        this.itemName = itemName;
        this.category = category;
        this.currentQuantity = currentQuantity;
        this.lastUpdated = lastUpdated;
        this.reorderThreshold = reorderThreshold;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(float currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Integer getReorderThreshold() {
        return reorderThreshold;
    }

    public void setReorderThreshold(Integer reorderThreshold) {
        this.reorderThreshold = reorderThreshold;
    }

    @Override
    public String toString() {
        return "TrackStock{" +
                "itemName='" + itemName + '\'' +
                ", category='" + category + '\'' +
                ", currentQuantity=" + currentQuantity +
                ", lastUpdated=" + lastUpdated +
                ", reorderThreshold=" + reorderThreshold +
                '}';
    }
}
