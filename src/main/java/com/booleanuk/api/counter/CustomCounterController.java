package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("counter/custom")
public class CustomCounterController {

    private HashMap<String, Integer> counters;

    public CustomCounterController() {
        this.counters = new HashMap<>();
        counters.put("counter1", 0);
    }

    @GetMapping("/{name}")
    public int getCounter(@PathVariable String name) {
        return counters.computeIfAbsent(name, k -> 0);
    }

    @GetMapping("/{name}/increment")
    public int incrementCounter(@PathVariable String name) {
        return counters.compute(name, (k,v) -> (v == null) ? 1 : v + 1);
    }

    @GetMapping("/{name}/decrement")
    public int decrementCounter(@PathVariable String name) {
        return counters.compute(name, (k,v) -> (v == null) ? 1 : v - 1);

    }

}
