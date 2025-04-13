package com.example.oop_final_project.Masum;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private String orderId;
    private LocalDate orderDate;
    private String orderStatus;
    private double calculateTotal;
    private ArrayList<OrderItem> orderItem;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public ArrayList<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(ArrayList<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }
    public void calculateTotal(){
        FishData.class.getName();

    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderItem=" + orderItem +
                '}';
    }
}
