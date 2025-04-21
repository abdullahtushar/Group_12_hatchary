package com.example.oop_final_project.AbdullahAlMamun;

import java.time.LocalDate;

public class BreedingRecord {
    private String fishName;
    private LocalDate date;

    public BreedingRecord(String fishName, LocalDate date) {
        this.fishName = fishName;
        this.date = date;
    }

    public String getFishName() {
        return fishName;
    }

    public void setFishName(String fishName) {
        this.fishName = fishName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }




}
