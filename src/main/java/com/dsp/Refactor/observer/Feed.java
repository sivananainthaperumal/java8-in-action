package com.dsp.Refactor.observer;

import java.util.ArrayList;
import java.util.List;

public class Feed implements Subject {

    public final List<Observer> observers = new ArrayList<>();
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers(String tweet) {
        observers.stream().forEach(observer -> observer.notify(tweet));
    }
}
