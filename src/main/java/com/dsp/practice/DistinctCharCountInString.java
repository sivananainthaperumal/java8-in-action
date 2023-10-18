package com.dsp.practice;

import com.dsp.streams.Dish;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.dsp.streams.Menu.menu;
import static java.util.stream.Collectors.groupingBy;

public class DistinctCharCountInString {

    public static void main(String[] args) {

        String str = "abcdABCDabcd";

        Map<String,Integer> values= new HashMap<>();
        Arrays.stream(str.split("")).forEach(x -> {
            if(!values.containsKey(x)){
                values.put(x,1);
            }else{
                values.put(x,values.get(x)+1);
            }
        });

        System.out.println(values);
    }

}
