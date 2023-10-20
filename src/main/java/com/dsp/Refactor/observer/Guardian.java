package com.dsp.Refactor.observer;

public class Guardian implements Observer{
    @Override
    public void notify(String tweet) {
        System.out.println("Breaking news from Guardian ..."+ tweet);
    }
}
