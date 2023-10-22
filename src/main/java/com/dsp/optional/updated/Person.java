package com.dsp.optional.updated;

import java.util.Optional;

public class Person {

    private String name;
    private Optional<Car> car = Optional.empty();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = Optional.of(car);
    }

    public void setOptionalCar(Optional<Car> car){
        this.car =car;
    }
}
