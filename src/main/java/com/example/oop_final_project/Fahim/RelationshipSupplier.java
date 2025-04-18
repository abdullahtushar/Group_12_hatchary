package com.example.oop_final_project.Fahim;

import java.time.LocalDate;

public class RelationshipSupplier {
    private String name;
    private Integer contact;
    private String productCategories;
    private LocalDate expiryDate;
    private String pricingTerm;

    public RelationshipSupplier(String name, Integer contact, String productCategories, LocalDate expiryDate, String pricingTerm) {
        this.name = name;
        this.contact = contact;
        this.productCategories = productCategories;
        this.expiryDate = expiryDate;
        this.pricingTerm = pricingTerm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public String getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(String productCategories) {
        this.productCategories = productCategories;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getPricingTerm() {
        return pricingTerm;
    }

    public void setPricingTerm(String pricingTerm) {
        this.pricingTerm = pricingTerm;
    }

    @Override
    public String toString() {
        return "RelationshipSupplier{" +
                "name='" + name + '\'' +
                ", contact=" + contact +
                ", productCategories='" + productCategories + '\'' +
                ", expiryDate=" + expiryDate +
                ", pricingTerm='" + pricingTerm + '\'' +
                '}';
    }
}
