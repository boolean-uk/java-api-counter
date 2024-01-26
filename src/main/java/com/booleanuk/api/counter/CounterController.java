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
    private int counter;
    private Map<String, Integer> counterMap;

    public CounterController() {
        this.counter = 0;
        this.counterMap = new HashMap<>();
    }

    @GetMapping
    public int getCounter() {
        return this.counter;
    }

    @GetMapping("/increment")
    public int getCounterIncrement() {
        this.counter++;
        return this.counter;
    }

    @GetMapping("/decrement")
    public int getCounterDecrement() {
        this.counter--;
        return this.counter;
    }

    @GetMapping("custom/{name}")
    public int getCustomCounter(@PathVariable String name) {
        if (this.counterMap.containsKey(name)) {
            return this.counterMap.get(name);
        }
        this.counterMap.put(name, 0);
        return -1;
    }
}
