package com.booleanuk.api.counter;

public class Counter {
    private int count;
    private String name;

    public Counter(String name) {
        this.name = name;
        this.count = 0;
    }

    public Counter(String name, int value) {
        this(name);
        this.count = value;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
