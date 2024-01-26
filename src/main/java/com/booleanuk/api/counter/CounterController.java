package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("counter")
public class CounterController {
    private int counter;
    private HashMap<String, Integer> customCounters;

    public CounterController() {
        this.counter = 0;
        this.customCounters = new HashMap<>();
    }

    @GetMapping
    public int getCounter() {
        return this.counter;
    }

    @GetMapping("increment")
    public int incrementCounter() {
        this.counter += 1;
        return this.counter;
    }

    @GetMapping("decrement")
    public int decrementCounter() {
        this.counter -= 1;
        return this.counter;
    }

    @GetMapping("custom/{name}")
    public int getCustomCounter(@PathVariable String name) {
        if(this.customCounters.containsKey(name)) {
            return this.customCounters.get(name);
        }
        this.customCounters.put(name, 0);
        return this.customCounters.get(name);
    }

    @GetMapping("custom/{name}/increment")
    public int incrementCounter(@PathVariable String name) {
        if(this.customCounters.containsKey(name)) {
            this.customCounters.replace(name, this.customCounters.get(name) + 1);
            return this.customCounters.get(name);
        }
        this.customCounters.put(name, 1);
        return this.customCounters.get(name);
    }

    @GetMapping("custom/{name}/decrement")
    public int decrementCounter(@PathVariable String name) {
        if(this.customCounters.containsKey(name)) {
            this.customCounters.replace(name, this.customCounters.get(name) - 1);
            return this.customCounters.get(name);
        }
        this.customCounters.put(name, -1);
        return this.customCounters.get(name);
    }
}
