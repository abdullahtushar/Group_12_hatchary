package com.example.oop_final_project.Fahim;

import java.time.LocalDate;

public class CustomerComplaints {
    private String name;
    private String complaint;
    private Integer contact;
    private LocalDate date;

    public CustomerComplaints(String name, String complaint, Integer contact, LocalDate date) {
        this.name = name;
        this.complaint = complaint;
        this.contact = contact;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CustomerComplaints{" +
                "name='" + name + '\'' +
                ", complaint='" + complaint + '\'' +
                ", contact=" + contact +
                ", date=" + date +
                '}';
    }
}
