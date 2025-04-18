package com.example.oop_final_project.Fahim;

import java.time.LocalDate;

public class Promotion {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String title;
    private Float discount;
    private String description;

    public Promotion(String name, LocalDate startDate, LocalDate endDate, String title, Float discount, String description) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.discount = discount;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTittle(String title) {
        this.title = title;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", tittle='" + title + '\'' +
                ", discount=" + discount +
                ", description='" + description + '\'' +
                '}';
    }
}
