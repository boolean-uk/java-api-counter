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
    HashMap<String, Integer> names;


    public CounterController() {
        this.counter = 0;
        this.names = new HashMap<>();
    }

    @GetMapping
    public String getCounter() {
        return  "" + counter;
    }

    @GetMapping("/increment")
    public String incrementCounter() {
        counter++;
       return  "" + counter;
    }

    @GetMapping("/decrement")
    public String decrementCounter() {
        counter--;
        return "" + counter;
    }

    @GetMapping("custom/{name}")
    public String createCustom(@PathVariable String name) {
        if(!names.containsKey(name)) {
            names.put(name, 0);
        }
        return names.get(name).toString();
    }

    @GetMapping("custom/{name}/increment")
    public String createCustomIncrement(@PathVariable String name) {
        names.put(name, names.getOrDefault(name,0) + 1);
        return names.get(name).toString();
    }

    @GetMapping("custom/{name}/decrement")
    public String createCustomDecrement(@PathVariable String name) {
        names.put(name, names.getOrDefault(name,0) - 1);
        return names.get(name).toString();
    }
}


