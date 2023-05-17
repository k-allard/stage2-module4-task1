package com.mjc.stage2;

public class ThreadSafeSingleton {
    private static final ThreadSafeSingleton instance = new ThreadSafeSingleton();

    private ThreadSafeSingleton() {
    }

    public static ThreadSafeSingleton getInstance() {
        return instance;
    }
}
