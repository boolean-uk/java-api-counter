package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter")
public class CounterController {

    private int number;

    public CounterController() {
        this.number = 0;
    }

    @GetMapping
    public int returnNumber() {
        return this.number;
    }

    @GetMapping("/increment")
    public int increaseNumber() {
        number += 1;
        return this.number;
    }

    @GetMapping("/decrement")
    public int decreaseNumber() {
        number -= 1;
        return this.number;
    }

}