package com.dsp.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    public static <T> void print(List<T> list, Consumer<T> c){
        for (T t: list) {
            c.accept(t);
        }
    }

    public static void main(String[] args) {

        print(Arrays.asList(1,2,3,4,5),(i)-> System.out.print(i));

    }
}
