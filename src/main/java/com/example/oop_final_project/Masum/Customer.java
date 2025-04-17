package com.example.oop_final_project.Masum;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Serializable {
    private String name, phone, location, fishName, status;
    private double orderAmount, pricePerkg, total;
    private LocalDate orderDate;

    public Customer(String name, String phone, String location, String fishName, String status, double orderAmount, double pricePerkg, double total, LocalDate orderDate) {
        this.name = name;
        this.phone = phone;
        this.location = location;
        this.fishName = fishName;
        this.status = status;
        this.orderAmount = orderAmount;
        this.pricePerkg = pricePerkg;
        this.total = total;
        this.orderDate = orderDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFishName() {
        return fishName;
    }

    public void setFishName(String fishName) {
        this.fishName = fishName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public double getPricePerkg() {
        return pricePerkg;
    }

    public void setPricePerkg(double pricePerkg) {
        this.pricePerkg = pricePerkg;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}