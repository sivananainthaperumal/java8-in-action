package com.dsp.Refactor.chainofresponsiblity;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ChainOfResponsibilityExample {

    public static void main(String[] args) {
        ProcessingObject<String> p1 = new HeadTextProcessingObject();
        ProcessingObject<String> p2 = new AddFooter();
        p1.setSuccessor(p2);

        String result = p1.handle("siva");
        System.out.println(result);

        //using lambda

        UnaryOperator<String> process1 = (text ) -> "Header "+text;

        UnaryOperator<String> process2 = (text) -> "Footer "+ text;

        Function<String,String> pipeline = process1.andThen(process2);
        String result2 = pipeline.apply("hello");

        System.out.println(result2);

    }
}
