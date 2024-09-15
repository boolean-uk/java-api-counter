package com.booleanuk.api.counter;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/Counter")
public class CounterController {
    private int counter;
    private HashMap<String, Integer> custom;

    public CounterController() {
        this.counter = 0;
        this.custom = new HashMap<>();
    }

    // Core
    public int getCounter() {
        return counter;
    }

    @GetMapping("/increment")
    public int increment() {
        counter++;
        return counter;
    }

    @GetMapping("/decrement")
    public int decrement() {
        counter--;
        return counter;
    }

    // Extension 1
    @GetMapping("/custom/{name}")
    public String getCustomCounter(@PathVariable(name = "name") String name) {
        if (!custom.containsKey(name)) {
            custom.put(name, 0);
        }
        return Integer.toString(custom.get(name));
    }

    @GetMapping("/custom/{name}/increment")
    public int customIncrement(@PathVariable(name = "name") String name) {
        if (custom.containsKey(name)) {
            custom.replace(name, custom.get(name)+1);
            return custom.get(name);
        } else {
            custom.put(name, 1);
        }
        return custom.get(name);
    }


    @GetMapping("/custom/{name}/decrement")
    public int customDecrement(@PathVariable(name = "name") String name) {
        if (custom.containsKey(name)) {
            custom.replace(name, custom.get(name)-1);
            return custom.get(name);
        } else {
            custom.put(name, -1);
        }
        return custom.get(name);
    }
}
