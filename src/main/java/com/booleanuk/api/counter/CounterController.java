package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/counter")
public class CounterController {
    private int counter;
    private HashMap<String, Integer> counterName;

    public CounterController() {
        this.counter = 0;
        this.counterName = new HashMap<>();
    }

    @GetMapping
    public int currentValue() {
        return this.counter;
    }

    @GetMapping("/increment")
    public int incrementCounter() {
        this.counter = counter + 1;
        return counter;
    }

    @GetMapping("/decrement")
    public int decrementCounter() {
        this.counter = counter - 1;
        return counter;
    }

    @GetMapping("/custom/{name}")
    public int nameCounter(@PathVariable String name) {
        if(counterName.containsKey(name)) {
            return counterName.get(name);
        } else {
            counterName.put(name, 0);
            return counterName.get(name);
        }
    }

    @GetMapping("/custom/{name}/increment")
    public int nameCounterIncrement(@PathVariable String name) {
        if (counterName.containsKey(name)) {
            int counterTemp = counterName.get(name);
            counterTemp = counterTemp + 1;
            counterName.put(name, counterTemp);
            return counterName.get(name);
        } else {
            counterName.put(name, 0);
            return counterName.get(name);
        }
    }

    @GetMapping("/custom/{name}/decrement")
    public int nameCounterDecrement(@PathVariable String name) {
        if (counterName.containsKey(name)) {
            int counterTemp = counterName.get(name);
            counterTemp = counterTemp - 1;
            counterName.put(name, counterTemp);
            return counterName.get(name);
        } else {
            counterName.put(name, 0);
            return counterName.get(name);
        }
    }

}
