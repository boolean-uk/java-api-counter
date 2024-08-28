package com.booleanuk.api.counter;

import org.springframework.stereotype.Component;

@Component
public class Counter {
    private int number;
    private String name;

    public Counter() {
        this.number = 0;
        this.name = "Bob";
    }

    public Counter(String name, int number) {
        this.number = number;
        this.name = name;
    }

    public void increment() {
        this.number++;
    }

    public void decrement() {
        this.number--;
    }

    public int getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }
}
