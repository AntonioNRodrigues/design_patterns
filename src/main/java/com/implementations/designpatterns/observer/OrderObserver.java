package com.implementations.designpatterns.observer;

public class OrderObserver implements Observer {

    @Override
    public void update(String eventType, String data) {
        System.out.println("OrderObserver: " + eventType + " - " + data);
    }
}
