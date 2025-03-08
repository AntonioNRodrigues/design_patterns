package com.implementations.designpatterns.singleton;

import java.util.HashMap;
import java.util.Map;

public class SyncSingleton {

    // When a variable is declared as volatile, any read or write operation on that variable will always go directly to the main memory.
    // This ensures that the most up-to-date value is always visible to all threads, preventing them from working with stale values cached in CPU registers.
    private static volatile SyncSingleton INSTANCE;

    private Map<String, String> map;

    private SyncSingleton() {
        map = new HashMap<>();
    }

    public static SyncSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (SyncSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SyncSingleton();
                }
            }
        }
        return INSTANCE;
    }

}
