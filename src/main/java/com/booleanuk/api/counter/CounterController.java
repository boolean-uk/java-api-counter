package com.booleanuk.api.counter;

import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/counter")
public class CounterController {
    private int count = 0;
    private HashMap<String, Integer> counters;
    public CounterController(){
        this.counters = new HashMap<>();
    }

    @GetMapping
    public int getCount(){
        return this.count;
    }
    @GetMapping("/increment")
    public int getIncrement(){
        return this.count++;
    }
    @GetMapping("/decrement")
    public int getDecrement(){
        return this.count--;
    }
    @GetMapping("/custom/{name}")
    public int getSpecificName(@PathVariable (name = "name") String name) {
        if (!this.counters.containsKey(name)) {
            this.counters.put(name,0);
        }
        return this.counters.get(name);

    }

    @GetMapping("/custom/{name}/increment")
    public int incrementNameCount(@PathVariable(name="name") String name) {
        int countCustom = 1;
        if (this.counters.containsKey(name)){
            countCustom = this.counters.get(name) + 1;

        }
        this.counters.put(name, countCustom);

        return countCustom;
    }
    @GetMapping("/custom/{name}/decrement")
    public int decrementNameCount(@PathVariable(name="name") String name) {
        int countCustom = -1;
        if (this.counters.containsKey(name)){
            countCustom = this.counters.get(name) - 1;
        }
        this.counters.put(name, countCustom);

        return countCustom;
    }
}
