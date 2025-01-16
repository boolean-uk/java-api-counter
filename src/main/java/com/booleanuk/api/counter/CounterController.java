package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/counter")
public class CounterController {
    private String defaultCounter;
    private Map<String, Integer> counters;

    public CounterController() {
        this.defaultCounter = "default";
        this.counters = new HashMap<>();
        this.counters.put(this.defaultCounter, 0);
    }

    @GetMapping("/custom/{name}/increment")
    public String incrementCustom(@PathVariable (name = "name") String counter) {
        getCustomCounter(counter);
        return increment(counter);
    }

    @GetMapping("/custom/{name}/decrement")
    public String decrementCustom(@PathVariable (name = "name") String counter) {
        getCustomCounter(counter);
        return decrement(counter);
    }

    @GetMapping("/custom/{name}")
    public String getCustomCounter(@PathVariable (name = "name") String counter) {
        if (!this.counters.containsKey(counter)) {
            this.counters.put(counter, 0);
        }
        return String.valueOf(this.counters.get(counter));
    }

    @GetMapping("/increment")
    public String increment() {
        return increment(defaultCounter);
    }

    private String increment(String counter) {
        this.counters.put(counter, this.counters.get(counter) + 1);
        return String.valueOf(this.counters.get(counter));
    }

    @GetMapping("/decrement")
    public String decrement() {
        return decrement(defaultCounter);
    }

    private String decrement(String counter) {
        this.counters.put(counter, this.counters.get(counter) - 1);
        return String.valueOf(this.counters.get(counter));
    }

    @GetMapping
    public String getValue() {
        return getValue(defaultCounter);
    }

    private String getValue(String counter) {
        return String.valueOf(this.counters.get(counter));
    }
}
