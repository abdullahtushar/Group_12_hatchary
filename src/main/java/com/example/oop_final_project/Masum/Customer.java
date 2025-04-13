package com.example.oop_final_project.Masum;

import java.util.ArrayList;

public class Customer {
    private String orderId, name, phone, location;
    private ArrayList<OrderItem> orderHistory;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public ArrayList<OrderItem> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(ArrayList<OrderItem> orderHistory) {
        this.orderHistory = orderHistory;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "orderId='" + orderId + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", location='" + location + '\'' +
                ", orderHistory=" + orderHistory +
                '}';
    }
}
