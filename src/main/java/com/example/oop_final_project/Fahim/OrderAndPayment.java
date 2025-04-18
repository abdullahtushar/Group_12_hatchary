package com.example.oop_final_project.Fahim;

public class OrderAndPayment {
    private String name;
    private String productType;
    private Integer contact;
    private Integer quantity;
    private Float cost;
    private String payment;

    public OrderAndPayment(String name, String productType, Integer contact, Integer quantity, Float cost, String payment) {
        this.name = name;
        this.productType = productType;
        this.contact = contact;
        this.quantity = quantity;
        this.cost = cost;
        this.payment = payment;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getCustomer() {
        return name;
    }

    public void setCustomer(String customer) {
        this.name= customer;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "OrderAndPayment{" +
                "customer='" + name + '\'' +
                ", productType='" + productType + '\'' +
                ", contact=" + contact +
                ", quantity=" + quantity +
                ", cost=" + cost +
                ", payment='" + payment + '\'' +
                '}';
    }
}
