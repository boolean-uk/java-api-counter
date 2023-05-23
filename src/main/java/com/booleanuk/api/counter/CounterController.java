package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter")
public class CounterController {
    private int value;

    public CounterController() {
        this.value = 0;
    }

    @GetMapping
    public int getValue() {
        return this.value;
    }
    @GetMapping("/increment")
    public int incrementValue() {
        return ++this.value;
    }
    @GetMapping("/decrement")
    public int decrementValue() {
        return --this.value;
    }
}
