package com.example.oop_final_project.Masum;

import java.io.Serializable;

public class Partnership implements Serializable {
    private String name, type, phone, address;

    public Partnership(String name, String type, String phone, String address) {
        this.name = name;
        this.type = type;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}