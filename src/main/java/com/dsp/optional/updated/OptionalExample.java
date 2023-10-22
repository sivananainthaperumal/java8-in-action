package com.dsp.optional.updated;

import java.util.Optional;

public class OptionalExample {

    public String getCarInsuranceNameTraditionally(Optional<Person> p){

        return p.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("unknown");
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Adam");
        OptionalExample example = new OptionalExample();
        System.out.println(example.getCarInsuranceNameTraditionally(Optional.of(person)));

    }
}
