package com.dsp.parallel;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PerformanceComparison {

    public static long measureSumPerformance(Function<Long,Long> addFunction,Long n){
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = addFunction.apply(n);
            long end = System.nanoTime();
            long duration = (end-start)/1000;
            fastest = duration<fastest?duration:fastest;

            System.out.println("Iterating "+i+ " at "+fastest+ " and the result is "+sum);
        }

        return fastest;

    }

    public static long sequentialSum(long n){
        return Stream.iterate(1L,i->i+1)
                .limit(n)
                .reduce(0L,Long::sum);
    }

    public static long parallelSum(long n){
        return Stream.iterate(1L,i->i+1)
                .limit(n)
                .parallel()
                .reduce(0L,Long::sum);
    }

    public static long rangedSum(long n){
        return LongStream.rangeClosed(1,n).sum();
    }

    public static long parallelRangeSum(long n){
        return LongStream.rangeClosed(1,n).parallel().sum();
    }

    public static void main(String[] args) {

        System.out.println("The sequential approach :"+measureSumPerformance(PerformanceComparison::sequentialSum, 100L));
        System.out.println("The parallel approach :"+measureSumPerformance(PerformanceComparison::parallelSum,100L));
        System.out.println("The range approach :"+measureSumPerformance(PerformanceComparison::rangedSum,100L));
        System.out.println("The parallel range approach :"+measureSumPerformance(PerformanceComparison::parallelRangeSum,100L));
    }
}
