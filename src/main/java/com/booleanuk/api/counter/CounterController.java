package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController()
@RequestMapping("/counter")
public class CounterController {
    private int count = 0;
    private final HashMap<String, Integer> customCount = new HashMap<>();

    @RequestMapping()
    public String getCount() {
        return "The count is " + count;
    }

    @RequestMapping("/increment")
    public String incrementCount() {
        count++;
        return "The count is now " + count;
    }

    @RequestMapping("/decrement")
    public String decrementCount() {
        count--;
        return "The count is now " + count;
    }

    @GetMapping("/custom/{name}")
    public String custom(@PathVariable String name) {
        if (!customCount.containsKey(name)) {
            customCount.put(name, 0);
            return "Custom count for " + name + " is created";
        }
        return "The count for " + name + " is now " + customCount.get(name);
    }

    @RequestMapping("/custom/{name}/increment")
    public String customIncrement(@PathVariable String name) {
        if (customCount.containsKey(name)) {
            customCount.put(name, customCount.get(name) + 1);
        } else {
            customCount.put(name, 1);
        }
        return "The count for " + name + " is now " + customCount.get(name);
    }

    @RequestMapping("/custom/{name}/decrement")
    public String customDecrement(@PathVariable String name) {
        if (customCount.containsKey(name)) {
            customCount.put(name, customCount.get(name) - 1);
        } else {
            customCount.put(name, -1);
        }
        return "The count for " + name + " is now " + customCount.get(name);
    }




}
