package com.booleanuk.api.counter;

public class UserCounter {
    private String name;
    private int counter;

    public UserCounter(String name) {
        this.name = name;
        this.counter = 0;
    }

    public String getName() {
        return name;
    }

    public int getCounter() {
        return counter;
    }

    public void plusCounter() {
        this.counter += 1;
    }

    public void minusCounter() {
        this.counter -= 1;
    }
}
