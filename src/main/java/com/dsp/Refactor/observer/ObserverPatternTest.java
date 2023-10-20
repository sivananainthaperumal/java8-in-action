package com.dsp.Refactor.observer;

public class ObserverPatternTest {

    public static void main(String[] args) {
        Feed feed = new Feed();
        feed.registerObserver(new NyTimes());
        feed.registerObserver(new Guardian());

        feed.registerObserver(str ->{
            System.out.println("Indian Express breaking news .."+str);
        });

        feed.registerObserver(str ->
                System.out.println("Dinamalar breaking news :"+str));
        feed.notifyObservers("India won the World cup ...");
    }
}
