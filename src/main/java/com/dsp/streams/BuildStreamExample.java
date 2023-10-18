package com.dsp.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class BuildStreamExample {

    public static void main(String[] args) {

        //Building stream from strings
        Stream<String> strings = Stream.of("sivan","dsp","perumal");
        strings.map(String::toUpperCase)
                .forEach(System.out::println);

        //Create empty stream
        Stream<String> emptyString = Stream.empty();

        //Creating stream from arrays
        int[] nums = {1,3,5,7,9,11,13};
        System.out.println(Arrays.stream(nums).sum());

        //from function
        Stream.iterate(0,n->n+2).limit(10).forEach(System.out::println);

        //generate
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
