package com.dsp.Refactor.observer;

public class NyTimes implements Observer{
    @Override
    public void notify(String tweet) {
        System.out.println("Breaking news in NY times ...."+tweet);
    }
}
