package com.dsp.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FunctionExample {

    public static <T,R> List<R> transform(List<T> list, Function<T,R> function){

        List<R> result = new ArrayList<>();

        for (T t: list) {
            result.add(function.apply(t));
        }
        return  result;
    }

    public static void main(String[] args) {

        Stream.of(transform(Arrays.asList("q","qw","qwe","qwer","qwert","qwert"),(String s) ->(Integer) s.length())).forEach(System.out::println);
    }
}
