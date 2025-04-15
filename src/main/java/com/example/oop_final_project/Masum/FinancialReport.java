package com.example.oop_final_project.Masum;

import java.time.LocalDate;

public class FinancialReport {
    //- reportType: string
//- startDate: Date
//- endDate: Date
//- totalIncome: float
//- totalExpenses: float
//- netProfitOrLoss: float
    private String reportType;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalIncome;
    private double totalLoss;
    private double netProfitOrLoss;

    public FinancialReport(String reportType, LocalDate startDate, LocalDate endDate, double totalIncome, double totalLoss, double netProfitOrLoss) {
        this.reportType = reportType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalIncome = totalIncome;
        this.totalLoss = totalLoss;
        this.netProfitOrLoss = netProfitOrLoss;
    }

    public FinancialReport(double totalIncome, LocalDate endDate, LocalDate startDate, String reportType, double totalLoss) {
        this.totalIncome = totalIncome;
        this.endDate = endDate;
        this.startDate = startDate;
        this.reportType = reportType;
        this.totalLoss = totalLoss;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
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

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getTotalLoss() {
        return totalLoss;
    }

    public void setTotalLoss(double totalLoss) {
        this.totalLoss = totalLoss;
    }

    public double getNetProfitOrLoss() {
        return netProfitOrLoss;
    }

    public void setNetProfitOrLoss(double netProfitOrLoss) {
        this.netProfitOrLoss = netProfitOrLoss;
    }
}
