package com.example.oop_final_project.Masum;

import java.time.LocalDate;

public class Summary {
    private double totalIncome;
    private double totalExpense;
    private double netProfitOrLoss;
    private LocalDate date;

    public Summary(double totalIncome, double totalExpense, double netProfitOrLoss, LocalDate date) {
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.netProfitOrLoss = netProfitOrLoss;
        this.date = date;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public double getNetProfitOrLoss() {
        return netProfitOrLoss;
    }

    public void setNetProfitOrLoss(double netProfitOrLoss) {
        this.netProfitOrLoss = netProfitOrLoss;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}