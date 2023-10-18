package com.dsp.practice;

import java.util.Arrays;

public class ArraySameElement {

    public static void main(String[] args) {

        Integer[] array1 = {1,2,3,4,5,6};
        Integer[] array2 = {1,2,3,4,6};
        long matchedCount =   Arrays.stream(array1).flatMap(i->Arrays.stream(array2).filter(j->i==j)).count();
        boolean sameArray = matchedCount==array1.length && matchedCount== array2.length?true:false;

        System.out.println("The arrays are same :"+sameArray);
    }
}
