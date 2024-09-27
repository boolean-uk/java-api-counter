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

    private int counter = 0;
    private Map<String, Integer> customCounters = new HashMap<>();
    @GetMapping
    public int getCounter() {
        return counter;
    }

    @GetMapping("/increment")
    public int incrementCounter() {
        counter++;
        return counter;
    }

    @GetMapping("/decrement")
    public int decrementCounter() {
        counter--;
        return counter;
    }

    @GetMapping("/custom/{name}")
    public int getCustomCounter(@PathVariable String name) {
        return customCounters.getOrDefault(name, 0);
    }

    @GetMapping("/custom/{name}/increment")
    public int incrementCustomCounter(@PathVariable String name) {
        int value = customCounters.getOrDefault(name, 0);
        value++;
        customCounters.put(name, value);
        return value;
    }

    @GetMapping("/custom/{name}/decrement")
    public int decrementCustomCounter(@PathVariable String name) {
        int value = customCounters.getOrDefault(name, 0);
        value--;
        customCounters.put(name, value);
        return value;
    }
}
