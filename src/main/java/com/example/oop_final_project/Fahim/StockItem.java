package com.example.oop_final_project.Fahim;

public class StockItem {
    private String itemName;
    private String category;
    private Integer initialQuantity;
    private Float unit;
    private Integer reorderThreshold;

    public StockItem(String itemName, String category, Integer initialQuantity, Float unit, Integer reorderThreshold) {
        this.itemName = itemName;
        this.category = category;
        this.initialQuantity = initialQuantity;
        this.unit = unit;
        this.reorderThreshold = reorderThreshold;
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

    public Integer getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(Integer initialQuantity) {
        this.initialQuantity = initialQuantity;
    }

    public Integer getReorderThreshold() {
        return reorderThreshold;
    }

    public void setReorderThreshold(Integer reorderThreshold) {
        this.reorderThreshold = reorderThreshold;
    }

    public Float getUnit() {
        return unit;
    }

    public void setUnit(Float unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "StockItem{" +
                "itemName='" + itemName + '\'' +
                ", category='" + category + '\'' +
                ", initialQuantity=" + initialQuantity +
                ", unit=" + unit +
                ", reorderThreshold=" + reorderThreshold +
                '}';
    }
}
