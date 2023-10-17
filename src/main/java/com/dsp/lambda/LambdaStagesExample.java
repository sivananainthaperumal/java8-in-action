package com.dsp.lambda;

import com.dsp.behavior.parameterization.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class LambdaStagesExample {

    public static void print(List<Apple> apples){
        Stream.of(apples).forEach(System.out::println);
    }

    //Using comparators
    public void sortingUsingComparator(List<Apple> apples){
        System.out.println("Sorting using comparator");
        apples.sort(new AppleCompare());
    }

    //using anonymous class
    public void sortingUsingAnonymous(List<Apple> apples){
        System.out.println("Sorting usng anonymous class");
        apples.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return ((Integer) a1.getWeight()).compareTo((Integer) a2.getWeight());
            }
        });
    }

    //using lambda expression
    public void sortingUsingLambda(List<Apple> apples){
        System.out.println("Sorting using Lambda expressions");
        apples.sort((a1,a2) -> ((Integer)a1.getWeight()).compareTo((Integer)a2.getWeight()));
    }

    //using static helper methods in comparator
    public void sortingUsingStaticComparatorHelperMethod(List<Apple> apples){
        System.out.println("using static helper methods in comparator");
        Comparator<Apple> comparator = comparing((a) -> a.getWeight());
        apples.sort(comparator);
    }

    //using static shortening of helper method
    public void sortingUsingConciseHelperMethod(List<Apple> apples){
        System.out.println("//using static shortening of helper method");
        apples.sort(comparing((a)->a.getWeight()));
    }


    //using static Helper
    public void sortingUSingStaticHelperMethodReference(List<Apple> apples){
        System.out.println("//using static Helper ");
        apples.sort(comparing(Apple::getWeight));
    }

    //Reverse Sorting
    public void reverse(List<Apple> apples){
        System.out.println("Reversing ");
        apples.sort(comparing(Apple::getWeight).reversed());
    }


    public static void main(String[] args) {

        LambdaStagesExample lambdaStagesExample = new LambdaStagesExample();
        List<Apple> apples =new ArrayList<>();
        BiFunction<Integer,String, Apple> apple = Apple::new;

        for (int i = 100; i > 1; i=i-10) {
            apples.add(apple.apply(i,"Red"));
        }

        print(apples);
        lambdaStagesExample.sortingUsingComparator(apples);

        print(apples);
        lambdaStagesExample.sortingUsingAnonymous(apples);

        print(apples);
        lambdaStagesExample.sortingUsingLambda(apples);

        print(apples);
        lambdaStagesExample.sortingUsingStaticComparatorHelperMethod(apples);

        print(apples);
        lambdaStagesExample.sortingUsingConciseHelperMethod(apples);

        print(apples);
        lambdaStagesExample.sortingUSingStaticHelperMethodReference(apples);

        print(apples);

        lambdaStagesExample.reverse(apples);
        print(apples);
    }

    class AppleCompare implements Comparator<Apple>{
        @Override
        public int compare(Apple a1, Apple a2) {
            return ((Integer)a1.getWeight()).compareTo((Integer) a2.getWeight());
        }
    }
}
