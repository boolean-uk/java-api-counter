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

    @GetMapping
    public int getCounter() {
        return this.counter;
    }

    /**
     * Increment before returning to avoid 'non-volatile' value to be shown.
     * @return
     */
    @GetMapping("increment")
    public int incrementCounter() {
        return ++this.counter;
    }

    /**
     * Decrement before returning to avoid 'non-volatile' value to be shown.
     * @return
     */
    @GetMapping("decrement")
    public int decrementCounter() {
        return --this.counter;
    }

    /**
     * EXTENSION 1
     * @param name
     * @return
     */
    @GetMapping("custom/{name}")
    public int getCustomCounter(@PathVariable String name) {
        if (!counters.containsKey(name)) {
            counters.put(name, 0);
        }
        return counters.get(name);
    }

    /**
     * EXTENSION 2
     */
    @GetMapping("custom/{name}/increment")
    public int incrementCustomCounter(@PathVariable String name) {
        if (counters.containsKey(name)) {
            counters.put(name, counters.get(name) + 1);
        } else {
            counters.put(name, 1);
        }
        return counters.get(name);
    }

    /**
     * Extension 3
     * @param name
     * @return
     */
    @GetMapping("custom/{name}/decrement")
    public int decrementCustomCounter(@PathVariable String name) {
        if (counters.containsKey(name)) {
            counters.put(name, counters.get(name) - 1);
        } else {
            counters.put(name, -1);
        }
        return counters.get(name);
    }
}
