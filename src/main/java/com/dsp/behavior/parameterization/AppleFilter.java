package com.dsp.behavior.parameterization;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
/*
  This pattern lets you encapsulate a behavior (a piece of code) and parameterize
  the behavior of methods by passing and using these behaviors
 */
public class AppleFilter {

    static List<Apple> inventories = new ArrayList<>();

    static {
        inventories.add(new Apple(30,"Red"));
        inventories.add(new Apple(40,"Green"));
        inventories.add(new Apple(50,"Red"));
        inventories.add(new Apple(155,"Red"));
        inventories.add(new Apple(160,"Green"));
    }

    public List<Apple> filterApples(List<Apple> inventories, ApplePredicate predicate){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventories) {
            if(predicate.test(apple)) result.add(apple);
        }

        return result;
    }

    public void prettyPrintApples(List<Apple> inventories,AppleFormatter formatter){

        for (Apple apple : inventories) {
            System.out.println(formatter.format(apple));
        }
    }

    public static void main(String[] args) {

        AppleFilter appleFilter = new AppleFilter();
        System.out.println("Using Apple Predicate");

        //Filter Apples by Green
        System.out.println("\nFilter Apples by Green");
        Stream.of(appleFilter.filterApples(inventories,new AppleGreenColorPredicate())).forEach(System.out::print);

        //Filter Apples with heavy weight apples
        System.out.println("\nFilter Apples with Heavy weight apples");
        Stream.of(appleFilter.filterApples(inventories,new AppleHeavyWeightPredicate())).forEach(System.out::print);

        //Filter Apple using Red color ( Anonymous class)
        System.out.println("\nFilter apple using anonymous class");
        Stream.of(appleFilter.filterApples(inventories, new ApplePredicate(){

            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals("Red");
            }
        })).forEach(System.out::print);

        //Filter Apples using lambdas
        System.out.println("\n Filter using lambdas to get red apples");
        Stream.of(appleFilter.filterApples(inventories,
                (Apple apple)->apple.getColor().equals("Red")))
                        .forEach(System.out::print);

        System.out.println("\nPrint Standard Apples");
        appleFilter.prettyPrintApples(inventories, new StandardAppleFormatter());

        System.out.println("\nPrint Fancy Apples");
        appleFilter.prettyPrintApples(inventories, new FancyAppleFormatter());

    }


}

class AppleGreenColorPredicate implements ApplePredicate{

    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals("Green");
    }
}

class AppleHeavyWeightPredicate implements ApplePredicate{

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight()>150;
    }
}

class StandardAppleFormatter implements AppleFormatter{

    @Override
    public String format(Apple apple) {
        return  "A Standard "+apple.getColor() +" apple.";
    }
}

class FancyAppleFormatter implements AppleFormatter {

    @Override
    public String format(Apple apple) {
        String chara=" Delicious";
        if(apple.getWeight()>150){
            chara+=" Humongous";
        }
        return "A "+apple.getColor()+ " "+chara+" apple.";
    }
}