package com.dsp.Refactor.observer;

public interface Subject {

    public void  registerObserver(Observer o);
    public void notifyObservers(String tweet);
}
