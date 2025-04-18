package com.example.oop_final_project.Masum;

import java.io.Serializable;
import java.time.LocalDate;

public class DailyTransaction implements Serializable {
    private String transactionId, type,sourceOrPurpose;
    private double amount;
    private String notes;
    private LocalDate date;

    public DailyTransaction(String transactionId, String type, String sourceOrPurpose, double amount, String notes, LocalDate date) {
        this.transactionId = transactionId;
        this.type = type;
        this.sourceOrPurpose = sourceOrPurpose;
        this.amount = amount;
        this.notes = notes;
        this.date = date;
    }

    public DailyTransaction(String type, String sourceOrPurpose, double amount, String notes, LocalDate date) {
        this.type = type;
        this.sourceOrPurpose = sourceOrPurpose;
        this.amount = amount;
        this.notes = notes;
        this.date = date;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSourceOrPurpose() {
        return sourceOrPurpose;
    }

    public void setSourceOrPurpose(String sourceOrPurpose) {
        this.sourceOrPurpose = sourceOrPurpose;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DailyTransaction{" +
                "transactionId='" + transactionId + '\'' +
                ", type='" + type + '\'' +
                ", sourceOrPurpose='" + sourceOrPurpose + '\'' +
                ", amount=" + amount +
                ", notes='" + notes + '\'' +
                ", date=" + date +
                '}';
    }
}
