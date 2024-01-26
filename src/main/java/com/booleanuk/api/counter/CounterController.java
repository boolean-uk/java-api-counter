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
    private Map<String, Integer> counters;

    public CounterController() {
        this.counter = 0;
        this.counters = new HashMap<>();
    }

    @GetMapping()
    public String showCounter() {
        return String.valueOf(this.counter);
    }

    @GetMapping("increment")
    public String increment() {
        this.counter++;
        return String.valueOf(this.counter);
    }

    @GetMapping("decrement")
    public String decrement() {
        this.counter--;
        return String.valueOf(this.counter);
    }

    @GetMapping("custom/{name}")
    public String getOrCreateCounter(@PathVariable String name) {
        if (!this.counters.containsKey(name)) {
            this.counters.put(name, 0);
        }
        return String.valueOf(this.counters.get(name));
    }

    @GetMapping("custom/{name}/increment")
    public String incrementCounter(@PathVariable String name) {
        if (!this.counters.containsKey(name)) {
            getOrCreateCounter(name);
        }
        this.counters.replace(name, this.counters.get(name) + 1);
        return String.valueOf(this.counters.get(name));
    }

    @GetMapping("custom/{name}/decrement")
    public String decrementCounter(@PathVariable String name) {
        if (!this.counters.containsKey(name)) {
            getOrCreateCounter(name);
        }
        this.counters.replace(name, this.counters.get(name) - 1);
        return String.valueOf(this.counters.get(name));
    }
}
