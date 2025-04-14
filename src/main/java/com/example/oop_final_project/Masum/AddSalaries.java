package com.example.oop_final_project.Masum;

public class AddSalaries {

    private String staffId, name,position;
    private double monthlySalary;
    private String status;

    public AddSalaries(String staffId, String name, String position, double monthlySalary, String status) {
        this.staffId = staffId;
        this.name = name;
        this.position = position;
        this.monthlySalary = monthlySalary;
        this.status = status;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
