package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter")
public class Counter {
    private int counter = 0;
    private final String counterString = "Counter: ";

    @GetMapping
    public String getCounter() {
        return this.counterString + this.counter;
    }

    @GetMapping("/increment")
    public String incrementCounter() {
        return this.counterString + ++this.counter;
    }

    @GetMapping("/decrement")
    public String decrementCounter() {
        return this.counterString + --this.counter;
    }
}
