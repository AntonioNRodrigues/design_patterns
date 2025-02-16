package com.implementations.designpatterns.observer;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderSubjectTest {

    @Test
    void registerObserverAddsObserverToList() {
        OrderSubject orderSubject = new OrderSubject();
        Observer observer = mock(Observer.class);
        orderSubject.registerObserver(observer);
        orderSubject.notifyObservers("event", "data");
        verify(observer).update("event", "data");
    }

    @Test
    void unregisterObserverRemovesObserverFromList() {
        OrderSubject orderSubject = new OrderSubject();
        Observer observer = mock(Observer.class);
        orderSubject.registerObserver(observer);
        orderSubject.unregisterObserver(observer);
        orderSubject.notifyObservers("event", "data");
        verify(observer, never()).update("event", "data");
    }

    @Test
    void notifyObserversCallsUpdateOnAllObservers() {
        OrderSubject orderSubject = new OrderSubject();
        Observer observer1 = mock(Observer.class);
        Observer observer2 = mock(Observer.class);
        orderSubject.registerObserver(observer1);
        orderSubject.registerObserver(observer2);
        orderSubject.notifyObservers("event", "data");
        verify(observer1).update("event", "data");
        verify(observer2).update("event", "data");
    }

    @Test
    void notifyObserversWithNoObserversDoesNotThrowException() {
        OrderSubject orderSubject = new OrderSubject();
        assertDoesNotThrow(() -> orderSubject.notifyObservers("event", "data"));
    }
}