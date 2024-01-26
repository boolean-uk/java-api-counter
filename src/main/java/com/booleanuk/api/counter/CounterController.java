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

    private Map<String, Integer> counters = new HashMap<>();

    @GetMapping("/custom/{name}")
    public int getCustomCounter(@PathVariable String name) {
        if (counters.containsKey(name)) {
            return counters.get(name);
        } else {
            counters.put(name, 0);
            return 0;
        }
    }

    @GetMapping("/custom/{name}/increment")
    public int incrementCustomCounter(@PathVariable String name) {
        int currentValue = counters.getOrDefault(name, 0);
        int newValue = currentValue + 1;
        counters.put(name, newValue);
        return newValue;
    }

    @GetMapping("/custom/{name}/decrement")
    public int decrementCustomCounter(@PathVariable String name) {
        int currentValue = counters.getOrDefault(name, 0);
        int newValue = currentValue - 1;
        counters.put(name, newValue);
        return newValue;
    }
}