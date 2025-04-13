package com.example.oop_final_project.Masum;

import java.time.LocalDate;

public class Budget {
    private double feed, medicine, utility, salaries, total;
    private LocalDate startDate, endDate;

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

    @Override
    public String toString() {
        return "Budget{" +
                "feed=" + feed +
                ", medicine=" + medicine +
                ", utility=" + utility +
                ", salaries=" + salaries +
                ", total=" + total +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
