package com.example.oop_final_project.Masum;

import java.io.Serializable;
import java.time.LocalDate;

public class Overtime implements Serializable{
//    - Employee name, ID, department
//- Date, hours worked, hourly rate,total
//- Supervisor approval status.

    private String staffName,id,department,status;
    private int hour,rate,total;
    private LocalDate date;

    public Overtime(String staffName, String id, String department, String status, int hour, int rate, int total, LocalDate date) {
        this.staffName = staffName;
        this.id = id;
        this.department = department;
        this.status = status;
        this.hour = hour;
        this.rate = rate;
        this.total = total;
        this.date = date;
    }

    public Overtime(String staffName, String id, String department, String status, int hour, int rate, LocalDate date) {
        this.staffName = staffName;
        this.id = id;
        this.department = department;
        this.status = status;
        this.hour = hour;
        this.rate = rate;
        this.date = date;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
