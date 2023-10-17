package com.dsp.lambda;

import com.dsp.behavior.parameterization.Apple;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceExample {

    public static void main(String[] args) {


        Supplier<Apple> apple = Apple::new;

        System.out.println(apple.get());

        BiFunction<Integer,String,Apple> apple2 = Apple::new;

        System.out.println(apple2.apply(12,"Red"));

    }
}
