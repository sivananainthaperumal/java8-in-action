package com.dsp.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static com.dsp.streams.Menu.*;
public class MappingExample {


    public static void main(String[] args) {

        //Simple mapping
        List<String> dishNames = menu.stream()
                                     .map(Dish::getName)
                                     .collect(Collectors.toList());

        display(dishNames);

        List<Integer> charCount = menu.stream().
                map(Dish::getName).
                map(String::length).
                collect(Collectors.toList());

        display(charCount);

        //can't return individual chars
        List<String[]> distinctChar = menu.stream()
                .map(Dish::getName)
                .map(dish->dish.split(""))
                .distinct()
                .collect(Collectors.toList());

        //using flatMap
        List<String> distinctCharInDishNames = menu.stream()
                .map(Dish::getName)
                .map(dish->dish.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        display(distinctCharInDishNames);

        List<Integer> squared = menu.stream()
                .map(Dish::getCalorie)
                .map(i->i*i)
                .collect(Collectors.toList());

        display(squared);

        //Finding pairs
        List<Integer> xCoordinates = Arrays.asList(1,2,3);
        List<Integer> yCoordinates = Arrays.asList(4,5,6);
        List<int[]> pairs =  xCoordinates.stream()
                .flatMap(i->yCoordinates.stream()
                        .map(j ->new int[]{i,j}))
                .collect(Collectors.toList());

        display(pairs);

        //divisble by 3
        List<int[]> threeFactors = xCoordinates.stream()
                .flatMap(i->yCoordinates.stream()
                        .filter(j->(i+j)%3==0)
                        .map(j-> new int[]{i,j}))
                .collect(Collectors.toList());
        display(threeFactors);
    }
}
