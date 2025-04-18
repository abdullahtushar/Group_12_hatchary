package com.example.oop_final_project.Fahim;

import java.time.LocalDate;

public class FarmInformation {
    private String farmHistory;
    private String fishSpecies;
    private Integer workingHour;
    private String location;

    public FarmInformation(String farmHistory, String fishSpecies, Integer workingHour, String location) {
        this.farmHistory = farmHistory;
        this.fishSpecies = fishSpecies;
        this.workingHour = workingHour;
        this.location = location;
    }

    public String getFarmHistory() {
        return farmHistory;
    }

    public void setFarmHistory(String farmHistory) {
        this.farmHistory = farmHistory;
    }

    public String getFishSpecies() {
        return fishSpecies;
    }

    public void setFishSpecies(String fishSpecies) {
        this.fishSpecies = fishSpecies;
    }

    public Integer getWorkingHour() {
        return workingHour;
    }

    public void setWorkingHour(Integer workingHour) {
        this.workingHour = workingHour;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "FarmInformation{" +
                "farmHistory='" + farmHistory + '\'' +
                ", fishSpecies='" + fishSpecies + '\'' +
                ", workingHour=" + workingHour +
                ", location='" + location + '\'' +
                '}';
    }
}
