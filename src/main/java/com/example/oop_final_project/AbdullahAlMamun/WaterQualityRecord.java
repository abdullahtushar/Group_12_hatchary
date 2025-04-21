package com.example.oop_final_project.AbdullahAlMamun;

public class WaterQualityRecord {
    private String pHlevel;
    private String waterQuality;

    public WaterQualityRecord(String pHlevel, String waterQuality) {
        this.pHlevel = pHlevel;
        this.waterQuality = waterQuality;
    }

    public String getpHlevel() {
        return pHlevel;
    }

    public void setpHlevel(String pHlevel) {
        this.pHlevel = pHlevel;
    }

    public String getWaterQuality() {
        return waterQuality;
    }

    public void setWaterQuality(String waterQuality) {
        this.waterQuality = waterQuality;
    }
}