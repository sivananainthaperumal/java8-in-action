package com.dsp.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static com.dsp.streams.Menu.*;
public class ReducingExample {

    public static void main(String[] args) {

        //using reduce : finding sum
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        System.out.println("The sum of all numbers :"+numbers.stream().reduce(0,(a,b)->a+b));

        System.out.println("Simplied sum of all numbers :"+numbers.stream().reduce(0,Integer::sum));

        System.out.println("Simplied without initial arg:"+numbers.stream().reduce(Integer::sum).get());

        //using reduct : product
        System.out.println("The product of all numbers :"+numbers.stream().reduce(1,(a,b)->a*b));

        //using max from reduce
        System.out.println("The Dish name of max calorie from menu: "+menu.stream().max(Comparator.comparing(Dish::getCalorie)).get());
        System.out.println("The max num :"+numbers.stream().reduce(Integer::max));

        //using min
        System.out.println("The Dish with min calorie from menu :"+menu.stream().min(Comparator.comparing(Dish::getCalorie)).get());
        System.out.println("The min num :"+numbers.stream().reduce(Integer::min));

        //count
        System.out.println("The number of dishes using reduce :"+menu.stream().map(dish -> 1).reduce(0,Integer::sum));
        System.out.println("The number of dishes using count :"+menu.stream().count());

    }
}
