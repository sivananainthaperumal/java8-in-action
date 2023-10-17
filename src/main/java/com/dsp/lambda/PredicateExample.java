package com.dsp.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateExample {

    public static <T> List<T> filter(List<T> list, Predicate<T> p){

        List<T> result = new ArrayList<>();
        for (T t: list) {
            if(p.test(t)){
                result.add(t);
            }

        }

        return result;
    }

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("");
        strings.add("");
        strings.add("");
        strings.add("you");

        List<String> test= filter(strings,(s)->s.equals("you"));
        System.out.println("The empty string count is "+test.size());
        //Stream.of(filter(strings,((s) -> s.isEmpty()))).forEach(System.out::print);

    }
}
