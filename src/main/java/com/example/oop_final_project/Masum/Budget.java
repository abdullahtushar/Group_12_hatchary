package com.example.oop_final_project.Masum;

import java.io.Serializable;
import java.io.StringReader;
import java.time.LocalDate;

public class Budget implements Serializable {
    private double feed, medicine, utility, salaries, total;
    private LocalDate startDate, endDate;
    private String  status;

    public Budget(double feed, double medicine, double utility, double salaries, double total, LocalDate startDate, LocalDate endDate, String status) {
        this.feed = feed;
        this.medicine = medicine;
        this.utility = utility;
        this.salaries = salaries;
        this.total = total;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public double getFeed() {
        return feed;
    }

    public void setFeed(double feed) {
        this.feed = feed;
    }

    public double getMedicine() {
        return medicine;
    }

    public void setMedicine(double medicine) {
        this.medicine = medicine;
    }

    public double getUtility() {
        return utility;
    }

    public void setUtility(double utility) {
        this.utility = utility;
    }

    public double getSalaries() {
        return salaries;
    }

    public void setSalaries(double salaries) {
        this.salaries = salaries;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
