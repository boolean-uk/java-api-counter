package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("counter")
public class CounterController {
    private int counter = 0;
    private HashMap<String, Integer> customs;

    public CounterController() {
        this.customs = new HashMap<>();
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

    @GetMapping("custom/{name}")
    public int customCounter(@PathVariable String name) {
        if(this.customs.containsKey(name)) {
            this.customs.put(name, this.customs.get(name));
        } else {
            this.customs.put(name, 0);
        }
        return this.customs.get(name);
    }
    @GetMapping("custom/{name}/increment")
    public int customCounterIncrement(@PathVariable String name) {
        if(this.customs.containsKey(name)) {
            this.customs.put(name, this.customs.get(name)+1);
        } else {
            this.customs.put(name, 0);
        }
        return this.customs.get(name);
    }
    @GetMapping("custom/{name}/decrement")
    public int customCounterDecrement(@PathVariable String name) {
        if(this.customs.containsKey(name)) {
            this.customs.put(name, this.customs.get(name)-1);
        } else {
            this.customs.put(name, 0);
        }
        return this.customs.get(name);
    }

}
