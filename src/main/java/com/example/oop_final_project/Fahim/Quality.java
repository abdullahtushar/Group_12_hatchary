package com.example.oop_final_project.Fahim;

public class Quality {
    private String supplier;
    private Integer quantity;
    private String shipmentCondition;

    public Quality(String supplier, Integer quantity, String shipmentCondition) {
        this.supplier = supplier;
        this.quantity = quantity;
        this.shipmentCondition = shipmentCondition;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getShipmentCondition() {
        return shipmentCondition;
    }

    public void setShipmentCondition(String shipmentCondition) {
        this.shipmentCondition = shipmentCondition;
    }

    @Override
    public String toString() {
        return "Quality{" +
                "supplier='" + supplier + '\'' +
                ", quantity=" + quantity +
                ", shipmentCondition='" + shipmentCondition + '\'' +
                '}';
    }
}
