package com.example.bmicalculator;



import java.util.ArrayList;

public class Food {
    private String name;
    private int proteins;
    private int fats;
    private int carbohydrates;
    private int calories;

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getFats() {
        return fats;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", proteins=" + proteins +
                "}";
    }

    public String toListElement() {
        return this.name + " - " + this.calories + " cal";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFats(double numericCellValue) {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }




}


