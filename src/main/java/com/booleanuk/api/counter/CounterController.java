package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("counter")
public class CounterController {

    private int counter;
    private HashMap<String, Integer> counters = new HashMap<>();

    public CounterController(){
        this.counter = 0;
    }

    @GetMapping
    public int getCounter() {
        return this.counter;
    }

    @GetMapping("increment")
    public int incrementCounter() {
        this.counter++;
        return this.counter;
    }

    @GetMapping("decrement")
    public int decrementCounter() {
        this.counter--;
        return this.counter;
    }


    //Extension tasks from here

    @GetMapping("custom/{name}")
    public String customCounter(@PathVariable String name) {
        if (!counters.containsKey(name)) {
            counters.put(name, 0);
            return "Counter created with name: " + name;
        } else {
            return name + ": " + counters.get(name);
        }
    }

    @GetMapping("custom/{name}/increment")
    public int incrementCustomCounter(@PathVariable String name) {
        if (!counters.containsKey(name)) {
            counters.put(name, 1);
            return 1;
        } else {
            counters.put(name, counters.get(name) + 1);
            return counters.get(name);
        }
    }

    @GetMapping("custom/{name}/decrement")
    public int decrementCustomCounter(@PathVariable String name) {
        if (!counters.containsKey(name)) {
            counters.put(name, -1);
            return -1;
        } else {
            counters.put(name, counters.get(name) - 1);
            return counters.get(name);
        }
    }
}
