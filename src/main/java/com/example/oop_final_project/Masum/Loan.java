package com.example.oop_final_project.Masum;

import java.io.Serializable;
import java.time.LocalDate;

public class Loan implements Serializable {
    private double amount;
    private String purposeOfLoan,status;
    private LocalDate applyDate, returnDate;

    public Loan(double amount, String purposeOfLoan, LocalDate applyDate, LocalDate returnDate) {
        this.amount = amount;
        this.purposeOfLoan = purposeOfLoan;
        this.applyDate = applyDate;
        this.returnDate = returnDate;
    }

    public Loan(double amount, String purposeOfLoan, String status, LocalDate applyDate, LocalDate returnDate) {
        this.amount = amount;
        this.purposeOfLoan = purposeOfLoan;
        this.status = status;
        this.applyDate = applyDate;
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPurposeOfLoan() {
        return purposeOfLoan;
    }

    public void setPurposeOfLoan(String purposeOfLoan) {
        this.purposeOfLoan = purposeOfLoan;
    }

    public LocalDate getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(LocalDate applyDate) {
        this.applyDate = applyDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
