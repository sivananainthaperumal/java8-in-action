package com.dsp.streams;

import java.util.*;
import java.util.stream.Collectors;


/*
Stream api - declarative, composable and parallelizable
-> a sequence of elements from a source
that supports data processing operations
 */
public class StreamIntro {

    List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );

/*    public void populateMenu(){
        menu.add(new Dish("Dosa",120));
        menu.add(new Dish("Chapathi", 240));
        menu.add(new Dish("Salad",80));
        menu.add(new Dish("Biryani", 680));
        menu.add(new Dish("Fried Rice", 440));
        menu.add(new Dish("Idli", 40));
    }*/

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
        streamIntro.printDishes(streamIntro.menu);
        System.out.println("Low Calorie Dishes");
        streamIntro.printDishes(streamIntro.getLowCalorieDishes());

        //Stream way of sorting and filtering
        System.out.println("Using stream api");
        List<Dish> lowCalorieDishes = streamIntro.menu.stream()
                        .filter(dish->dish.getCalorie()<400)
                        .sorted(Comparator.comparing(Dish::getCalorie))
                        .collect(Collectors.toList());

        streamIntro.printDishes(lowCalorieDishes);



    }
}
