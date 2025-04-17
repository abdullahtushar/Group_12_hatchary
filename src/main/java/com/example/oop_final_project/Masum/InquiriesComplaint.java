package com.example.oop_final_project.Masum;

import java.io.Serializable;

public class InquiriesComplaint implements Serializable {
    private String name,content,response,status;

    public InquiriesComplaint (String name, String content, String response, String status) {
        this.name = name;
        this.content = content;
        this.response = response;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
