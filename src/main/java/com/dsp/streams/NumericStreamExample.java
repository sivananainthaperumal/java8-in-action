package com.dsp.streams;

import java.util.Comparator;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import static com.dsp.streams.Menu.*;

public class NumericStreamExample {

    public static void main(String[] args) {

        //using mapToInt to create IntStream
        System.out.println("The sum of calorie from menu :"+menu.stream()
                .mapToInt(Dish::getCalorie)
                .sum());

        //optionalInt and default value
        OptionalInt maxCalorie = menu.stream()
                .mapToInt(Dish::getCalorie)
                .max();

        System.out.println("The max calorie :"+maxCalorie.orElse(1));

        //Ranges
        IntStream evenStream = IntStream.rangeClosed(1,100)
                .filter(i -> i%2==0);

        System.out.println(evenStream.count());
    }
}
