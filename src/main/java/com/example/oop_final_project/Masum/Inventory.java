package com.example.oop_final_project.Masum;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<FishStock> stocks;

    public ArrayList<FishStock> getStocks() {
        return stocks;
    }

    public void setStocks(ArrayList<FishStock> stocks) {
        this.stocks = stocks;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "stocks=" + stocks +
                '}';
    }
}
