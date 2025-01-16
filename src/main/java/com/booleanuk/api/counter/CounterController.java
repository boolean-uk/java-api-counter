package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("counter")
public class CounterController {
    private int counter = 0;

    @GetMapping
    public int getCount() {
        return counter;
    }

    @GetMapping("increment")
    public int increment() {
        counter++;
        return counter;
    }

    @GetMapping("decrement")
    public int decrement() {
        counter--;
        return counter;
    }

}
