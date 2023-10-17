package com.dsp.lambda;

import com.dsp.behavior.parameterization.Apple;

import java.util.function.Predicate;

public class ComposePredicateExample {

    public static void main(String[] args) {

        Predicate<Apple> redApple = apple -> apple.getColor().equals("Red");

        //using negate predicate
        Predicate<Apple> notRedApple = redApple.negate();
        // using and on predicate
        Predicate<Apple> redAndWeightApple = redApple.and(applex -> applex.getWeight()>150);
        //using or on predicate
        Predicate<Apple> redOrWeightApple = redApple.or(apple -> apple.getWeight()>150);

        Apple heavyWeight = new Apple(160,"Red");
        Apple apple = new Apple(100,"Red");
        Apple greenUnderWeightApple = new Apple(40,"Green");

        System.out.println(redApple.test(apple));
        System.out.println(notRedApple.test(apple));


        System.out.println(redAndWeightApple.test(apple));
        System.out.println(redAndWeightApple.test(heavyWeight));
        System.out.println(redOrWeightApple.test(apple));
        System.out.println(redOrWeightApple.test(greenUnderWeightApple));

    }
}
