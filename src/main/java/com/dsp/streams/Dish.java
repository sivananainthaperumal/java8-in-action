package com.dsp.streams;

public class Dish {

    private String name;
    private int calorie;
    private boolean vegetarian;
    private Type type;

    public Dish(String name, boolean vegetarian,int calorie, Type type) {
        this.name = name;
        this.calorie = calorie;
        this.vegetarian = vegetarian;
        this.type = type;
    }

    public Dish(String name, int calorie) {
        this.name = name;
        this.calorie = calorie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", calorie=" + calorie +
                ", vegetarian=" + vegetarian +
                ", type=" + type +
                '}';
    }

    public enum Type {
        MEAT,FISH,OTHER
    }

    public enum calorieLevel {LOW,NORMAL,FAT};

}
