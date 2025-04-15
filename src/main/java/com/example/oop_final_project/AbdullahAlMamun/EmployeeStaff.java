package com.example.oop_final_project.AbdullahAlMamun;

public class EmployeeStaff {
    Integer id;
    String name;
    String designation;

    public EmployeeStaff(Integer id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "EmployeeStaff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
