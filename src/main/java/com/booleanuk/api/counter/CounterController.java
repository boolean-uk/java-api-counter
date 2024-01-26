package com.booleanuk.api.counter;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/counter")
public class CounterController {

    private int counterValue = 0;

    @GetMapping
    public String getCounterValue() {
        return "Value of counter: " + this.counterValue;
    }


    @GetMapping("/increment")
    public String incrementCounter() {
        this.counterValue += 1;
        return "Value of counter: " + this.counterValue;
    }


    @GetMapping("/decrement")
    public String decrementCounter() {
        this.counterValue -= 1;
        return "Value of counter: " + this.counterValue;
    }


}
