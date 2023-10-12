package com.dsp.behavior.parameterization;

public class Apple implements Fruit{

    private int weight;
    private String color;

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
