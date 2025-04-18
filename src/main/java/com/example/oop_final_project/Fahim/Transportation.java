package com.example.oop_final_project.Fahim;

import java.time.LocalDate;

public class Transportation {
    private String name;
    private String supplierType;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private String status;

    public Transportation(String name, String supplierType, LocalDate arrivalDate, LocalDate departureDate, String status) {
        this.name = name;
        this.supplierType = supplierType;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplierType() {
        return supplierType;
    }

    public void setSupplierType(String supplierType) {
        this.supplierType = supplierType;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transportation{" +
                "name='" + name + '\'' +
                ", supplierType='" + supplierType + '\'' +
                ", arrivalDate=" + arrivalDate +
                ", departureDate=" + departureDate +
                ", status='" + status + '\'' +
                '}';
    }
}
