package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("counter")
public class CounterController {
    private int counter;

    public CounterController() {
            counter = 0;
    }

    @GetMapping("/increment")
    public String increseCounter() {
        counter++;
        return counter + "";
    }

    @GetMapping("/decrement")
    public String decreseCounter() {
        counter--;
        return counter + "";
    }
}
