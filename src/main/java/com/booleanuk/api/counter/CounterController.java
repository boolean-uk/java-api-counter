package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("counter")
public class CounterController {
    private int counter;
    private HashMap<String, Integer> counters;
    public CounterController(){
        counter = 0;
        counters = new HashMap<>();
    }

    @GetMapping
    public int getCounter(){
        return counter;
    }

    @GetMapping("increment")
    public int incrementCounter(){
        counter++;
        return getCounter();
    }

    @GetMapping("decrement")
    public int decrementCounter(){
        counter--;
        return getCounter();
    }

    @GetMapping("custom/{name}")
    public int customCounter(@PathVariable String name){
        if (!counters.containsKey(name)) {
            counters.put(name, 0);
        }
        return counters.get(name);
    }

    @GetMapping("custom/{name}/increment")
    public int customCounterIncrease(@PathVariable String name){
        if (!counters.containsKey(name)){
            counters.put(name, 1);
        } else {
            counters.put(name, counters.get(name) + 1);
        }
        return counters.get(name);
    }

    @GetMapping("custom/{name}/decrement")
    public int customCounterDecrease(@PathVariable String name) {
        if (!counters.containsKey(name)) {
            counters.put(name, -1);
        } else {
            counters.put(name, counters.get(name) - 1);
        }
        return counters.get(name);
    }
}
