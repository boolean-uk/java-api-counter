package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("counter")
public class CounterController {
    private int counter;
    private Map<String, Integer> counters = new HashMap<>();

    public CounterController() {
        this.counter = 0;
    }


    @GetMapping()
    public String getCounter() {
        return "The counter is " + this.counter;
    }

    @GetMapping("/increment")
    public String increment() {
        this.counter += 1;
        return "The counter is " + this.counter;
    }

    @GetMapping("/decrement")
    public String decrement() {
        this.counter -= 1;
        return "The counter is " + this.counter;
    }

    @GetMapping("/custom/{name}")
    public String MakeOrGetCounter(@PathVariable String name) {
        int value = counters.getOrDefault(name, 0);
        counters.putIfAbsent(name, value);
        return name + " has value: " + value;
    }

    @GetMapping("/custom/{name}/increment")
    public String CustomIncrement(@PathVariable String name) {
        int currentValue = counters.getOrDefault(name, 0);
        int newValue = currentValue + 1;
        counters.put(name, newValue);
        return name + " has value: " + newValue;
    }

    @GetMapping("/custom/{name}/decrement")
    public String CustomDecrement(@PathVariable String name) {
        int currentValue = counters.getOrDefault(name, 0);
        int newValue = currentValue - 1;
        counters.put(name, newValue);
        return name + " has value: " + newValue;
    }

}
