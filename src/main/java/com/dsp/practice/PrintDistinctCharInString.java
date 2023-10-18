package com.dsp.practice;

import com.dsp.streams.Dish;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.dsp.streams.Menu.menu;

public class PrintDistinctCharInString {

    public static void main(String[] args) {
        String str = "abcdABCDabcd";

        System.out.println(Arrays.stream(str.split("")).distinct().collect(Collectors.joining()));
    }
}
