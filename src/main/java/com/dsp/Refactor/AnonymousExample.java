package com.dsp.Refactor;

public class AnonymousExample {

    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable using anonymous class");
            }
        };

        r1.run();


        Runnable r2 = () -> System.out.println("Runnable using lambda behavior expression");

        r2.run();

        int a=10;
        Runnable r3 = ()-> {
            // this will cause compile time issue a=5;
            System.out.println("Accessing a using lambda expression :"+a);
        };

        r3.run();

    }
}
