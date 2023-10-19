package com.dsp.Refactor;

import com.dsp.streams.Dish;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.dsp.streams.Menu.*;

public class MethodReferenceExample {

    public static void main(String[] args) {

        Map<Dish.calorieLevel, List<Dish>> dishesGroupedByCalorieLevel = menu.stream()
                .collect(Collectors.groupingBy(Dish::getCalorieLevel));

        System.out.println(dishesGroupedByCalorieLevel);

        System.out.println(menu.stream().collect(Collectors.summingInt(Dish::getCalorie)));

    }
}
