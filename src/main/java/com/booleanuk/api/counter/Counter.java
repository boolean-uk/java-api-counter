package com.booleanuk.api.counter;

public class Counter {
    private int counter;

    public Counter() {
        this.counter = setCount(1);
    }

    public int decrementCount(){
        return this.setCount(this.getCount()-1);
    }
    public int incrementCount(){
        return this.setCount(this.getCount()+1);
    }

    public int getCount() {
        return this.counter;
    }

    public int setCount(int counter) {
        return this.counter = counter;
    }
}
