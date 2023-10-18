package com.dsp.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreasTuple {

    public static void main(String[] args) {

        Stream<double[]> tuples = IntStream.rangeClosed(1,100)
                .boxed()
                .flatMap( a -> IntStream.rangeClosed(1,100)
                        .mapToObj(b -> new double[] {a,b, Math.sqrt(a*a+b*b)})
                        .filter(t ->t[2]%1==0));


        tuples.limit(10).forEach(t -> System.out.println(t[0]+","+ t[1]+","+t[2]));
    }
}
