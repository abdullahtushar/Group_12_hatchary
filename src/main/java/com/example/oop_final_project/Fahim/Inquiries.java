package com.example.oop_final_project.Fahim;

public class Inquiries {
    private String customerName;
    private String inquiryType;
    private Integer contact;
    private String message;

    public Inquiries(String customerName, String inquiryType, Integer contact, String message) {
        this.customerName = customerName;
        this.inquiryType = inquiryType;
        this.contact = contact;
        this.message = message;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getInquiryType() {
        return inquiryType;
    }

    public void setInquiryType(String inquiryType) {
        this.inquiryType = inquiryType;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Inquiries{" +
                "customerName='" + customerName + '\'' +
                ", inquiryType='" + inquiryType + '\'' +
                ", contact=" + contact +
                ", message='" + message + '\'' +
                '}';
    }
}
