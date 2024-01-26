package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("counter")
public class CounterController {

    private int counter;

    @GetMapping
    public String getCounter() {
        return "<h1> counter: " + this.counter + "<h1>";
    }

    @GetMapping("increment")
    public String incrementCounter() {
        this.counter += 1;
        return "<h1> New counter value: " + this.counter + "<h1>";
    }

    @GetMapping("decrement")
    public String decrementCounter() {
        this.counter -= 1;
        return "<h1> New counter value: " + this.counter + "<h1>";
    }
}
