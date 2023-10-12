package com.dsp.behavior.parameterization;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AppleFunctionality {

    static List<Apple> inventories = new ArrayList<>();

    static {
        inventories.add(new Apple(30,"Red"));
        inventories.add(new Apple(40,"Green"));
        inventories.add(new Apple(50,"Red"));
        inventories.add(new Apple(155,"Red"));
        inventories.add(new Apple(160,"Green"));
    }

    public List<Apple> filterGreenApples(List<Apple> inventory){
            List<Apple> result = new ArrayList<>();

        for (Apple apple:inventory) {
            if("Green".equals(apple.getColor())){
                result.add(apple);
            }
        }

        return result;
    }

    public List<Apple> filterApples(List<Apple> inventories, String color){
        List<Apple> result = new ArrayList<>();

        for (Apple apple: inventories) {
            if(color.equals(apple.getColor())){
                result.add(apple);
            }
        }

        return result;
    }

    public List<Apple> filterApplesByWeight(List<Apple> inventories,int weight){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventories) {
            if(apple.getWeight()>weight){
                result.add(apple);
            }
        }

        return result;
    }


    public static void main(String[] args) {

        AppleFunctionality functionality = new AppleFunctionality();

        //first attempt behavior parameterizing
        //Filtering Green apples without color parameter
        System.out.println("\nFiltering Green apples ..");

        Stream.of(functionality.filterGreenApples(inventories)).forEach(System.out::print);

        //second attempt behavior parameterizing
        //Filtering Green apples
        System.out.println("\nFiltering Green apples ..");
        Stream.of(functionality.filterApples(inventories,"Green")).forEach(System.out::print);

        //Filtering Red apples
        System.out.println("\nFiltering Red apples ..");
        Stream.of(functionality.filterApples(inventories,"Red")).forEach(System.out::print);

        //Filtering apples by Weight
        System.out.println("\nFiltering apples by weight ..");
        Stream.of(functionality.filterApplesByWeight(inventories,150)).forEach(System.out::print);


    }
}
