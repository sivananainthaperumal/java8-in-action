package com.dsp.streams;

import java.util.Comparator;

import static com.dsp.streams.Menu.*;
public class FindingExample {

    public static void main(String[] args) {

        //using anyMatch
        if(menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The restaurant has vegetarian friendly options");
        }

        if(menu.stream().allMatch(dish -> dish.getCalorie()<1000)){
            System.out.println("The restaurant has all healthy options");
        }

        if(menu.stream().noneMatch(dish -> dish.getCalorie()>500)){
            System.out.println("The restaurant has un healthy menu options as well");
        }

        //find any
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(dish -> System.out.println(dish));

        //find first
        menu.stream()
                .filter(Dish::isVegetarian)
                .sorted(Comparator.comparing(Dish::getCalorie))
                .findFirst()
                .ifPresent(dish -> System.out.println(dish));
    }
}
