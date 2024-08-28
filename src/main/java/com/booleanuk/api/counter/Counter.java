package com.booleanuk.api.counter;

import org.springframework.stereotype.Component;

@Component
public class Counter {
    private String name;
    private int counter;

    public Counter(String name) {
        this.name = name;
        this.counter = 0;
    }

    public Counter(){
        this.name = "jostein";
        this.counter = 0;
    }

    public void increment(){
        counter += 1;
    }

    public void decrement(){
        counter -= 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
