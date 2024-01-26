package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/counter/custom/{name}")
public class CounterController {
    Counter counter;
    private HashMap<String, Counter> counters;

    public CounterController() {
        this.counter = new Counter();
        this.counters = new HashMap<>();
    }

    @GetMapping
    public String getCounter(@PathVariable String name) {
        if(!this.counters.containsKey(name)) {
            Counter counter = new Counter();
            this.counters.put(name, counter);
        }
        return this.counters.get(name).getCounter();
    }

    @GetMapping("/increment")
    public String incrementCounter(@PathVariable String name) {
        if(!this.counters.containsKey(name)) {
            Counter counter = new Counter();
            this.counters.put(name, counter);
        }
        return counters.get(name).incrementCounter();
    }

    @GetMapping("/decrement")
    public String decrementCounter(@PathVariable String name) {
        if(!this.counters.containsKey(name)) {
            Counter counter = new Counter();
            this.counters.put(name, counter);
        }
        return counters.get(name).decrementCounter();
    }
}