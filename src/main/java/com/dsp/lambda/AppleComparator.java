package com.dsp.lambda;

import com.dsp.behavior.parameterization.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AppleComparator {

    static List<Apple> inventories = new ArrayList<>();

    static {
        inventories.add(new Apple(30,"Red"));
        inventories.add(new Apple(40,"Green"));
        inventories.add(new Apple(50,"Red"));
        inventories.add(new Apple(155,"Red"));
        inventories.add(new Apple(160,"Green"));
    }


    public void filterByComparator(){
        Comparator<Apple> byWeight = new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2){
                return ((Integer)a1.getWeight()).compareTo((Integer) a2.getWeight());
            }
        };
    }

    public void filterByLambda(){
        Comparator<Apple> byWeight = (Apple a1, Apple a2) -> ((Integer)a1.getWeight()).compareTo((Integer) a2.getWeight());
    }

    public static void main(String[] args) {


    }
}
