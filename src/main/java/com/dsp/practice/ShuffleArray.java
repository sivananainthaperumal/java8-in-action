package com.dsp.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;

public class ShuffleArray {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};

        Arrays.stream(array).forEach(i -> System.out.print(i+","));

        Random random = new Random();

        for (int i=0;i<array.length;i++){
            int randomIdx = random.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomIdx];
            array[randomIdx] = temp;
        }
        System.out.println();
        Arrays.stream(array).forEach(i -> System.out.print(i+","));
    }
}
