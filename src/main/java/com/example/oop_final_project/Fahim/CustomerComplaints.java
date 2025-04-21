package com.example.oop_final_project.Fahim;

import java.time.LocalDate;

public class CustomerComplaints {
    private String name;
    private String complaint;
    private Integer contact;
    private LocalDate date;
    private String status;
    private String resolutionNote;

    public CustomerComplaints(String name, String complaint, Integer contact, LocalDate date, String status, String resolutionNote) {
        this.name = name;
        this.complaint = complaint;
        this.contact = contact;
        this.date = date;
        this.status = status;
        this.resolutionNote = resolutionNote;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getComplaint() { return complaint; }
    public void setComplaint(String complaint) { this.complaint = complaint; }

    public Integer getContact() { return contact; }
    public void setContact(Integer contact) { this.contact = contact; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getResolutionNote() { return resolutionNote; }
    public void setResolutionNote(String resolutionNote) { this.resolutionNote = resolutionNote; }

    @Override
    public String toString() {
        return "CustomerComplaints{" +
                "name='" + name + '\'' +
                ", complaint='" + complaint + '\'' +
                ", contact=" + contact +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", resolutionNote='" + resolutionNote + '\'' +
                '}';
    }
}
