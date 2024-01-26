package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter")
public class CounterController {
    private int number;

    public CounterController() {
        number = 0;
    }

    @GetMapping("/increment")
    public int incrementAndGetNumber() {
        this.number++;
        return this.number;
    }

    @GetMapping("/decrement")
    public int decrementAndGetNumber() {
        this.number--;
        return this.number;
    }
}
