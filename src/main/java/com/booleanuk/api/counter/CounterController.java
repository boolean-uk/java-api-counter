package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class CounterController {

    private int counter = 0;

    public CounterController() {
        this.counter = 0;
    }

    @GetMapping("/counter") 
    public int getCounter() {
        return this.counter;
    }

    @GetMapping("/counter/increment")
    public int incrementCounter() {
        this.counter++;
        return this.counter;
    }

    @GetMapping("/counter/decrement")
    public int decrementCounter() {
        this.counter--;
        return this.counter;
    }
}