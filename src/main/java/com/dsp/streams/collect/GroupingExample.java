package com.dsp.streams.collect;

import com.dsp.streams.Dish;
import org.w3c.dom.ls.LSOutput;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static com.dsp.streams.Menu.*;
public class GroupingExample {

    public static void main(String[] args) {

        //Single Groupby
        Map<Dish.Type, List<Dish>> dishesGroupedByType = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesGroupedByType);

        Map<Dish.Type,Map<Dish.calorieLevel,List<Dish>>> dishGroupedByTypeAndCalorie = menu.stream()
                .collect(
                    groupingBy(Dish::getType,
                       groupingBy(dish -> {
                            if (dish.getCalorie() < 400) return Dish.calorieLevel.LOW;
                            else if (dish.getCalorie() >= 400 && dish.getCalorie() <= 500) return Dish.calorieLevel.NORMAL;
                            else return Dish.calorieLevel.FAT;
                       })
                    )
                );


        //Nested Groupby
        System.out.println(dishGroupedByTypeAndCalorie);


        //Group by counting items
        Map<Dish.Type,Long> itemsInEachType = menu.stream().collect(groupingBy(Dish::getType,counting()));

        System.out.println(itemsInEachType);

        //Groupby and get max value
        Map<Dish.Type, Optional<Dish>> fattyFoodInEachCategory = menu.stream()
                .collect(groupingBy(Dish::getType, maxBy(Comparator.comparing(Dish::getCalorie))));
        System.out.println(fattyFoodInEachCategory);

        Map<Dish.Type,Optional<Dish>> lessFattyFoodInEachCategory = menu.stream()
                .collect(groupingBy(Dish::getType,minBy(Comparator.comparing(Dish::getCalorie))));
        System.out.println(lessFattyFoodInEachCategory);


        //Adapting to different datatype
        Map<Dish.Type,Dish> maxDishesInEachCategory = menu.stream()
                .collect(groupingBy(Dish::getType,
                        collectingAndThen(maxBy(Comparator.comparing(Dish::getCalorie)),Optional::get)));

        System.out.println(maxDishesInEachCategory);

        //Summing calorie of each category
        Map<Dish.Type,Integer> calorieCountOfEachCategory = menu.stream()
                .collect(groupingBy(Dish::getType,summingInt(Dish::getCalorie)));

        System.out.println(calorieCountOfEachCategory);
    }




}
