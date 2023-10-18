package com.dsp.streams;

import java.util.*;
import java.util.stream.Collectors;

import static com.dsp.streams.Menu.menu;


/*
Stream api - declarative, composable and parallelizable
-> a sequence of elements from a source
that supports data processing operations
 */
public class StreamIntro {


    public void printDishes(List<Dish> menu){
        for (Dish dish:menu) {
            System.out.println(dish);
        }
    }

    public List<Dish> getLowCalorieDishes(){

        List<Dish> lowCalorieDishes = new ArrayList<>();

        for (Dish dish: menu) {
            if ( dish.getCalorie()<400){
                lowCalorieDishes.add(dish);
            }
        }

        Collections.sort(lowCalorieDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish dish1, Dish dish2) {
                return Integer.compare(dish1.getCalorie(),dish2.getCalorie());
            }
        });
        return lowCalorieDishes;
    }


    public static void main(String[] args) {
        StreamIntro streamIntro = new StreamIntro();
        //streamIntro.populateMenu();
        System.out.println("All Menu");
        streamIntro.printDishes(menu);
        System.out.println("Low Calorie Dishes");
        streamIntro.printDishes(streamIntro.getLowCalorieDishes());

        //Stream way of sorting and filtering
        System.out.println("Using stream api");
        List<Dish> lowCalorieDishes = menu.stream()
                        .filter(dish->dish.getCalorie()<400)
                        .sorted(Comparator.comparing(Dish::getCalorie))
                        .collect(Collectors.toList());

        streamIntro.printDishes(lowCalorieDishes);



    }
}
