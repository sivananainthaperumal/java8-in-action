package com.dsp.practice;

import java.util.Arrays;

public class SecondLargestNumber {

    public static void main(String[] args) {

        int[] array = {1,2,3,4,5};

        System.out.println("The second largest number is : "+ Arrays.stream(array).sorted().skip(array.length-2).findFirst().getAsInt());
    }
}
