package com.example.oop_final_project.Fahim;

public class WarehouseManagement {
    private float temperature;
    private float humidity;
    private float OxygenLevels;

    public WarehouseManagement(float temperature, float humidity, float oxygenLevels) {
        this.temperature = temperature;
        this.humidity = humidity;
        OxygenLevels = oxygenLevels;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getOxygenLevels() {
        return OxygenLevels;
    }

    public void setOxygenLevels(float oxygenLevels) {
        OxygenLevels = oxygenLevels;
    }

    @Override
    public String toString() {
        return "WarehouseManagement{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", OxygenLevels=" + OxygenLevels +
                '}';
    }
}
