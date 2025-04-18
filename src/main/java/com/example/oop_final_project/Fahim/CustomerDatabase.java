package com.example.oop_final_project.Fahim;

public class CustomerDatabase {
    private String name;
    private String email;
    private Integer phone;
    private String status;

    public CustomerDatabase(String name, String email, Integer phone, String status) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CustomerDatabase{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", status='" + status + '\'' +
                '}';
    }
}
