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
    private final Map<String, Integer> counters;
    int counter;
    public CounterController() {
        this.counters = new HashMap<>();
        this.counter = 0;
    }

    @GetMapping ("/increment")
    public int incrementCounter(){
        this.counter += 1;
        return this.counter;
    }

    @GetMapping ("/decrement")
    public int decrementCounter(){
        this.counter -= 1;
        return this.counter;
    }

    @GetMapping
    public int getCounter(){
        return this.counter;
    }

    @GetMapping("/custom/{name}")
    public int getCustomCounter(@PathVariable("name") String name) {
        counters.putIfAbsent(name, 0);
        return counters.get(name);
    }

    @GetMapping("/custom/{name}/increment")
    public int incrementCustomCounter(@PathVariable("name") String name) {
        counters.put(name, counters.getOrDefault(name, 0) + 1);
        return counters.get(name);
    }

    @GetMapping("/custom/{name}/decrement")
    public int decrementCustomCounter(@PathVariable("name") String name) {
        counters.put(name, counters.getOrDefault(name, 0) - 1);
        return counters.get(name);
    }
}
