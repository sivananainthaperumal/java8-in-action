package com.dsp.Refactor.factory;

public class ProductFactoryExample {

    public static void main(String[] args) {
        Product product = ProductFactory.createProduct("loan");
        System.out.println(product);


    }
}
