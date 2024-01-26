package com.booleanuk.api.counter;

public class Counter {

    private int counterValue;
    private String name;


    public Counter(String name) {
        this.name = name;
        this.counterValue = 0;
    }

    public int getCounterValue() {
        return counterValue;
    }

    public void setCounterValue(int counterValue) {
        this.counterValue = counterValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
