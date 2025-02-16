package com.implementations.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class OrderSubject {
    private final List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String eventType, String data) {
        for (Observer observer : observers) {
            observer.update(eventType, data);
        }
    }
}
