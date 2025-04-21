package com.example.oop_final_project.Fahim;

import java.time.LocalDate;

public class CustomerFeedback {
    private String name;
    private String comments;
    private String rating;
    private LocalDate date;
    private String status;
    private String reply;

    public CustomerFeedback(String name, String comments, String rating, LocalDate date, String status, String reply) {
        this.name = name;
        this.comments = comments;
        this.rating = rating;
        this.date = date;
        this.status = status;
        this.reply = reply;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    @Override
    public String toString() {
        return "CustomerFeedback{" +
                "name='" + name + '\'' +
                ", comments='" + comments + '\'' +
                ", rating='" + rating + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", reply='" + reply + '\'' +
                '}';
    }
}

