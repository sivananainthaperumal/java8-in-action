package com.dsp.lambda;


import com.dsp.behavior.parameterization.Apple;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Stream;

//Reusing existing method definitions and pass them like lambdas
public class MethodReferenceExample {

    public static void print(List<String> list){
        Stream.of(list).forEach(System.out::println);
    }
    public static void main(String[] args) {

        List<String> str = Arrays.asList("c","a","b","A","B");
        print(str);
        //Traditional comparsion
        str.sort((s1,s2) ->s1.compareToIgnoreCase(s2));

        System.out.println("After sorting ....");
        print(str);
        str = Arrays.asList("c","a","b","A","B");
        //Method Reference
        print(str);
        str.sort(String::compareToIgnoreCase);
        print(str);

        Function<String,Integer> stringToInt = (s -> Integer.parseInt(s));
        System.out.println((stringToInt.apply("100").getClass()));

        // using method reference
        Function<String,Integer> stringToInt1 = Integer::parseInt;
        System.out.println((stringToInt1.apply("12")).getClass());

        BiPredicate<List<String>,String> findAValue = (list,element)->list.contains(element);
        System.out.println("The value is present :"+findAValue.test(str,"c"));
        System.out.println("The value is present :"+findAValue.test(str,"U"));

        // using method reference
        BiPredicate<List<String>,String> findingNemo = List::contains;
        System.out.println("The value is present :"+findAValue.test(str,"c"));
        System.out.println("The value is present :"+findAValue.test(str,"U"));

    }
}
