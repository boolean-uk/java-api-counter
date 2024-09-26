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
    private int count = 0;
    private Map<String, Integer> counters = new HashMap<>();

    @GetMapping
    public int getCount() {
        return this.count;
    }

    @GetMapping("increment")
    public int incrementCount() {
        return ++this.count;
    }

    @GetMapping("decrement")
    public int decrementCount() {
        return --this.count;
    }

    @GetMapping("custom/{name}")
    public int getCustomCount(@PathVariable(name="name") String name) {
        if (!this.counters.containsKey(name))
            this.counters.put(name, 0);

        return this.counters.get(name);
    }

    @GetMapping("custom/{name}/increment")
    public int incrementCustomCount(@PathVariable(name="name") String name) {
        int value = 1;

        if (this.counters.containsKey(name))
            value = this.counters.get(name) + 1;

        this.counters.put(name, value);

        return value;
    }

    @GetMapping("custom/{name}/decrement")
    public int decrementCustomCount(@PathVariable(name="name") String name) {
        int value = -1;

        if (this.counters.containsKey(name))
            value = this.counters.get(name) - 1;

        this.counters.put(name, value);

        return value;
    }
}
