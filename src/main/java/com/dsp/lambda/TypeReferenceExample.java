package com.dsp.lambda;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class TypeReferenceExample {

    public static void main(String[] args) {

        //with no boxing
        IntPredicate evenNumbers = (int i) -> i%2==0;
        System.out.println("100 is a even number "+ evenNumbers.test(101));

        // Auto boxing
        Predicate<Integer> oddNumbers = (Integer i) -> i%2==1;
        System.out.println("101 is a odd number "+ oddNumbers.test(101));

        //Type Reference
        Predicate<Integer> divisbleByThree = (i) -> i%3==0;
        System.out.println("The number is divisble by 3 :"+divisbleByThree.test(99));

        //Using local variable
        int localVariable= 1234;
        Runnable r = ()-> System.out.println(localVariable);
        r.run();

    }
}
