package com.dsp.optional;

public class OptionalExample {

    public String getCarInsuranceNameTraditionally(Person p){

        if(p!=null){
            if(p.getCar()!=null){
                if(p.getCar().getInsurance()!=null){
                    return p.getCar().getInsurance().getName();
                }
            }
        }

        return "unknown";
    }

    public static void main(String[] args) {
        Person person = new Person();

        OptionalExample example = new OptionalExample();
        System.out.println(example.getCarInsuranceNameTraditionally(new Person()));

    }
}
