package com.booleanuk.api.counter;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("counter")
public class CounterController {
    private int counter = 0;
    private HashMap<String, Integer> counters = new HashMap<>();

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

    @GetMapping("custom/{name}")
    public int getCustom(@PathVariable String name) {
        if (counters.containsKey(name)) {
            return counters.get(name);
        }

        // create new counter
        counters.put(name, 0);
        return counters.get(name);
    }

    @GetMapping("custom/{name}/increment")
    public int customIncrement(@PathVariable String name) {
        if (counters.containsKey(name)) {
            counters.put(name, counters.get(name) + 1);
            return counters.get(name);
        }

        // create new counter
        counters.put(name, 1);
        return counters.get(name);
    }

    @GetMapping("custom/{name}/decrement")
    public int customDecrement(@PathVariable String name) {
        if (counters.containsKey(name)) {
            counters.put(name, counters.get(name) - 1);
            return counters.get(name);
        }

        // create new counter
        counters.put(name, -1);
        return counters.get(name);
    }
}
