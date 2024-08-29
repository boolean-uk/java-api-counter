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
    private String counterString;
    private final HashMap<String, Integer> names;

    public CounterController() {
        this.counter = 0;
        this.counterString = "";
        this.names = new HashMap<>();
    }

    @GetMapping
    public String getCounter() {
        this.counterString = "" + this.counter;
        return this.counterString;
    }

    @GetMapping("/increment")
    public String increment() {
        this.counter++;
        return this.getCounter();
    }


    @GetMapping("/decrement")
    public String decrement() {
        this.counter--;
        return this.getCounter();
    }

    public String setCounterForName(String name, int val) {
        if (this.names.containsKey(name)) {
            this.names.put(name, this.names.get(name)+val);
        } else {
            this.names.put(name, val);
        }
        counterString = "" + this.names.get(name);
        return counterString;
    }

    @GetMapping("/custom/{name}")
    public String getCounterName(@PathVariable String name) {
        return setCounterForName(name, 0);
    }

    @GetMapping("/custom/{name}/increment")
    public String incrementName(@PathVariable String name) {
        return setCounterForName(name, 1);
    }


    @GetMapping("/custom/{name}/decrement")
    public String decrementName(@PathVariable String name) {
        return setCounterForName(name, -1);
    }
}
