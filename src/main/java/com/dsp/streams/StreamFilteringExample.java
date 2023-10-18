package com.dsp.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import static com.dsp.streams.Menu.menu;
import static com.dsp.streams.Menu.display;

public class StreamFilteringExample {


    public static void main(String[] args) {

        //filter taking predicate
        List<Dish> vegetarianMenu = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());

        display(vegetarianMenu);

        //using distinct
        List<Integer> numbers = Arrays.asList(1,3,4,56,7,2,3,5,6,7,4,2);

        numbers.stream().filter(i->i%2==0).distinct().forEach(i->System.out.println(i+" "));

        System.out.println("Display dishes above 400 calorie");
        List<Dish> dishesAbove400Calorie = menu.stream()
                .filter(dish -> dish.getCalorie()>400)
                .sorted(Comparator.comparing(Dish::getCalorie))
                .collect(Collectors.toList());
        display(dishesAbove400Calorie);

        //Truncating stream
        System.out.println("Display dishes above 400 calorie and max 3 ");
        List<Dish> threeMaxCaloriDishes = menu.stream()
                .filter(dish->dish.getCalorie()>400)
                .sorted(Comparator.comparing(Dish::getCalorie).reversed())
                .limit(3)
                .collect(Collectors.toList());
        display(threeMaxCaloriDishes);

        //skip stream
        System.out.println("Using skip");
        List<Dish> dishesWithCaloriesAbove400 = menu.stream()
                        .filter(dish -> dish.getCalorie()>400)
                        .sorted(Comparator.comparing(Dish::getCalorie))
                        .skip(3)
                        .collect(Collectors.toList());
        display(dishesWithCaloriesAbove400);
    }
}
