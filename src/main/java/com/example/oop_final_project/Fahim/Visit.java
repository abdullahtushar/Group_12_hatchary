package com.example.oop_final_project.Fahim;

import java.time.LocalDate;

public class Visit {
    private String name;
    private Integer visitor;
    private Integer contact;
    private LocalDate date;

    public Visit(String name, Integer visitor, Integer contact, LocalDate date) {
        this.name = name;
        this.visitor = visitor;
        this.contact = contact;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVisitor() {
        return visitor;
    }

    public void setVisitor(Integer visitor) {
        this.visitor = visitor;
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
        return "Visit{" +
                "name='" + name + '\'' +
                ", visitor=" + visitor +
                ", contact=" + contact +
                ", date=" + date +
                '}';
    }
}
