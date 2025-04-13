package com.example.oop_final_project.Masum;

public class OrderItem {

    private String itemId;
    private String fishType;
    private double quantity;
    private  double pricePerUnit;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getFishType() {
        return fishType;
    }

    public void setFishType(String fishType) {
        this.fishType = fishType;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemId='" + itemId + '\'' +
                ", fishType='" + fishType + '\'' +
                ", quantity=" + quantity +
                ", pricePerUnit=" + pricePerUnit +
                '}';
    }
}