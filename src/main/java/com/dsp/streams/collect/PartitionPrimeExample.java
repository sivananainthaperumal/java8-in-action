package com.dsp.streams.collect;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PartitionPrimeExample {

    public static boolean isPrime(int value){

        boolean ret = IntStream.range(2,value).noneMatch(i -> value%i==0);
        return ret;
    }
    public static void main(String[] args) {

        Map<Boolean, List<Integer>> primes=  IntStream.rangeClosed(2,100).boxed().collect(Collectors.partitioningBy(value ->isPrime(value)));

        System.out.println(primes);

    }
}
