package com.implementations.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public interface Observer {
    void update(String eventType, String data);
}

