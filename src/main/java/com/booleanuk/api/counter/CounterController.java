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
    private HashMap<String, Integer> counterMap;

    public CounterController() {
        this.counter = 0;
        this.counterMap = new HashMap<>();
    }

    @GetMapping
    public String getCounter() {
        return String.valueOf(this.counter);
    }

    @GetMapping("increment")
    public String increment() {
        this.counter++;
        return String.valueOf(this.counter);
    }

    @GetMapping("decrement")
    public String decrement() {
        this.counter--;
        return String.valueOf(this.counter);
    }

    @GetMapping("custom/{name}")
    public String getSpecificCounter(@PathVariable String name) {
        if (this.counterMap.get(name) == null) {
            this.counterMap.put(name, 0);
        }
        return name+": " + this.counterMap.get(name);
    }

    @GetMapping("custom/{name}/increment")
    public String specificIncrement(@PathVariable String name) {
        if (this.counterMap.get(name) == null) {
            this.counterMap.put(name, 1);
        } else {
            int counterValue = this.counterMap.get(name);
            this.counterMap.put(name, counterValue + 1);
        }
        return name+": " + this.counterMap.get(name);
    }

    @GetMapping("custom/{name}/decrement")
    public String specificDecrement(@PathVariable String name) {
        if (this.counterMap.get(name) == null) {
            this.counterMap.put(name, -1);
        } else {
            int counterValue = this.counterMap.get(name);
            this.counterMap.put(name, counterValue - 1);
        }
        return name+": " + this.counterMap.get(name);
    }
}
