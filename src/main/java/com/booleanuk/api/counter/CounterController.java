package com.booleanuk.api.counter;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/counter")
public class CounterController {
    private int number = 0;
    private HashMap<String, Integer> counters = new HashMap<>();

    @GetMapping("/increment")
    public int increment() {
        return ++number;
    }

    @GetMapping("/decrement")
    public int decrement() {
        return --number;
    }

    @GetMapping("/getnumber")
    public int getNumber() {
        return number;
    }

    @GetMapping("/custom/{name}")
    public int getCounter(@PathVariable String name) {
        if(counters.containsKey(name)) {
            return counters.get(name);
        }
        counters.put(name, 0);
        return counters.get(name);
    }

    @GetMapping("/custom/{name}/increment")
    public int incrementCounter(@PathVariable String name) {
        if(counters.containsKey(name)) {
            counters.put(name, counters.get(name) + 1);
            return counters.get(name);
        }
        counters.put(name, 1);
        return counters.get(name);
    }

    @GetMapping("/custom/{name}/decrement")
    public int decrementCounter(@PathVariable String name) {
        if(counters.containsKey(name)) {
            counters.put(name, counters.get(name) - 1);
            return counters.get(name);
        }
        counters.put(name, -1);
        return counters.get(name);
    }

}
