package com.dsp.streams.collect;

import com.dsp.streams.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;
import static com.dsp.streams.Menu.*;
public class CollectorsExample {

    public static void main(String[] args) {

        //Grouping the dishes using group by
        Map<Dish.Type, List<Dish>> dishesGroupedByType = menu.stream().collect(groupingBy(Dish::getType));

        //Reducing example using collectors
        System.out.println("The number of items in the menu:"+menu.stream().collect(counting()));
        System.out.println("Simple approach for count :"+menu.stream().count());

        //Finding max and min values of the stream
        System.out.println("The max calorie menu item"+menu.stream().collect(maxBy(Comparator.comparing(Dish::getCalorie))).get());

        System.out.println("The min calorie menu item"+menu.stream().collect(minBy(Comparator.comparing(Dish::getCalorie))).get());

        //Summing the calorie
        System.out.println("The total calorie in the menu :"+menu.stream().collect(summingInt(Dish::getCalorie)));

        //alternate way of summing up
        System.out.println("The traditional way of totalling calorie :"+menu.stream().map(Dish::getCalorie).reduce(0,(a,b) ->a+b));

        //summarzing the calorie
        System.out.println("The summary of the calorie :"+menu.stream().collect(summarizingInt(Dish::getCalorie)));

        //Joining strings
        System.out.println("The short menu :"+menu.stream().map(Dish::getName).collect(joining(",")));
    }
}
