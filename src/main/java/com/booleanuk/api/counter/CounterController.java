package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController()
@RequestMapping("/counter")
public class CounterController {

    private HashMap<String, Integer> counters;
    private int counter;

    public CounterController() {
        this.counters = new HashMap<>();
        this.counter = 0;
    }

    @GetMapping("increment")
    public int increment() {
        ++this.counter;
        return this.counter;
    }

    @GetMapping("decrement")
    public int decrement() {
        --this.counter;
        return this.counter;
    }

    @GetMapping
    public int getCounter() {
        return this.counter;
    }

    @GetMapping("custom/{name}")
    public int getCustomCounter(@PathVariable String name) {
        if (this.counters.get(name) == null) {
            this.counters.put(name, 0);
            return this.counters.get(name);
        } else {
            return this.counters.get(name);
        }
    }

    @GetMapping("custom/{name}/increment")
    public int getCustomCounterIncrement(@PathVariable String name) {
        if (this.counters.get(name) == null) {
            this.counters.put(name, 1);
            return this.counters.get(name);
        } else {
            this.counters.replace(name, this.counters.get(name) + 1);
            return this.counters.get(name);
        }
    }

    @GetMapping("custom/{name}/decrement")
    public int getCustomCounterDecrement(@PathVariable String name) {
        if (this.counters.get(name) == null) {
            this.counters.put(name, -1);
            return this.counters.get(name);
        } else {
            this.counters.replace(name, this.counters.get(name) - 1);
            return this.counters.get(name);
        }
    }

}
