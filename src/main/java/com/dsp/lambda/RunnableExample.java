package com.dsp.lambda;

public class RunnableExample {

    Runnable r1= new Runnable() {
        @Override
        public void run() {
            System.out.println("Process runnable r1");
        }
    };

    Runnable r2= ()-> System.out.println("Process runnable r2");

    public void process(Runnable r){
        r.run();
    }

    public static void main(String[] args) {
        RunnableExample runnableExample = new RunnableExample();
        runnableExample.process(runnableExample.r1);
        runnableExample.process(runnableExample.r2);
        runnableExample.process(()-> System.out.println("Process from lambda R3"));
    }
}
