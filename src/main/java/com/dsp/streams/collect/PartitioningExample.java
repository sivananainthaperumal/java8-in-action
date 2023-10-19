package com.dsp.streams.collect;

import com.dsp.streams.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.dsp.streams.Menu.*;
import static java.util.stream.Collectors.*;

public class PartitioningExample {

    public static void main(String[] args) {

        Map<Boolean, List<Dish>> partitionedMenu = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian));

        System.out.println(partitionedMenu);

        List<Dish> vegetarianDishes = partitionedMenu.get(true);

        System.out.println(vegetarianDishes);

        System.out.println("Filtering ..."+menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList()));

        //nesting partitioning and grouping
        System.out.println("Partitioning and Grouping :"+menu.stream().collect(partitioningBy(Dish::isVegetarian,groupingBy(Dish::getType))));

        System.out.println(menu.stream().collect(partitioningBy(Dish::isVegetarian,collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalorie)), Optional::get))));

        System.out.println(menu.stream().collect(partitioningBy(Dish::isVegetarian,
                collectingAndThen(minBy(Comparator.comparingInt(Dish::getCalorie)),Optional::get))));

        System.out.println(menu.stream().collect(partitioningBy(Dish::isVegetarian,partitioningBy(d->d.getCalorie()>400))));

        System.out.println(menu.stream().collect(partitioningBy(Dish::isVegetarian,counting())));

    }
}
