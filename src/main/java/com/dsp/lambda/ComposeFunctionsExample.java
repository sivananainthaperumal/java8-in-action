package com.dsp.lambda;

import java.util.function.Function;

public class ComposeFunctionsExample {

    public static void main(String[] args) {

        Function<Integer,Integer> increment = x->x+1;
        Function<Integer,Integer> multipleBy2 = x->x*2;

        Function<Integer,Integer> andThen = increment.andThen(multipleBy2);
        Function<Integer,Integer> compose = increment.compose(multipleBy2);

        System.out.println(andThen.apply(2));
        System.out.println(compose.apply(2));

    }
}
