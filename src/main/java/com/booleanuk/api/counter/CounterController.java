package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/counter")
public class CounterController {
    private int counter;
    private HashMap<String, Integer> counters = new HashMap<>();

    public CounterController() {
        //counters.put("counter", 0);
        //counters.replaceAll((k, v) -> 0);
    }

    @GetMapping
    public int getCounter() {
        return counter;
    }

    @GetMapping("/increment")
    public int getIncrement() {
        counter++;
        return counter;
    }

    @GetMapping("/decrement")
    public int getDecrement() {
        counter--;
        return counter;
    }

    @GetMapping("/custom/{name}")
    public int addCounter(@PathVariable String name) {
        int result;

        if (counters.containsKey(name)) {
            result = counters.get(name);
        } else {
            counters.put(name, 0);
            result = 0;
        }
        return result;
    }

    @GetMapping("/custom/{name}/increment")
    public int increaseCounter(@PathVariable String name) {
        int result;

        if (counters.containsKey(name)) {
            counters.replace(name, counters.get(name) + 1);
            result = counters.get(name);
        } else {
            counters.put(name, 1);
            result = 1;
        }
        return result;
    }

    @GetMapping("/custom/{name}/decrement")
    public int decreaseCounter(@PathVariable String name) {
        int result;

        if (counters.containsKey(name)) {
            counters.replace(name, counters.get(name) - 1);
            result = counters.get(name);
        } else {
            counters.put(name, -1);
            result = -1;
        }
        return result;
    }
}
