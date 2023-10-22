package com.dsp.completableFuture;

import java.util.concurrent.*;

public class SimpleFuture {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Double> future = executorService.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                Thread.sleep(1000);
                return 10.0;
            }
        });

        Future<Double> future1 = executorService.submit(()->{
            Thread.sleep(5000);
            return 10.0;
        });

        try {
            System.out.println(future.get());
            System.out.println(future1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
