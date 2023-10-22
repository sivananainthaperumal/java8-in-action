package com.dsp.optional.updated;

import java.util.Optional;

public class Car {

    private String make;
    private String model;
    private Integer year;

    private Optional<Insurance> insurance = Optional.empty();

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Optional<Insurance> getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = Optional.of(insurance);
    }

    public void setOptionalInsurance(Optional<Insurance> insurance){
        this.insurance = insurance;
    }
}
