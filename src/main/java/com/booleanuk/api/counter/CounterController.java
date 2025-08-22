package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/counter")
public class CounterController {
    private int value;
    private String name;
    private final Map<String, Integer>  counter = new HashMap<>();

    public CounterController() {
        this.value = 0;
    }

    @GetMapping
    public int getValue() {
        return value;
    }



    @GetMapping("/increment")
    public int increment() {
        value++;
        return value;
    }

    @GetMapping("/custom/{name}/increment")
    public String increment(@PathVariable("name") String name) {
        if (counter.containsKey(name)) {
            int current = counter.get(name);
            int newValue = current + 1;
            counter.put(name, newValue);
            return "hello " + name + " this is you new value: " + newValue;
        } else {
            counter.put(name, 1);
            return "hello " + name + " this is you new value: " + 1;
        }

    }

    @GetMapping("/custom/{name}/decrement")
    public String decrement(@PathVariable("name") String name) {
        if (counter.containsKey(name)) {
            int current = counter.get(name);
            int newValue = current - 1;
            counter.put(name, newValue);
            return "Hello " + name + ", you new points are: " + newValue;
        } else {
            counter.put(name, -1);
            return "Hello " + name + " this is you new points are: " + -1;
        }

    }

    @GetMapping("/decrement")
    public int decrement() {
        value--;
        return value;
    }

    @GetMapping("/custom/{name}")
    public String custom(@PathVariable String name) {
        if (counter.containsKey(name)) {
            return "Hello " + name + ", this is your current value:" + counter.get(name);
        } else {
            counter.put(name, 0);
            return "Hello " + name + ", you are new. this is your current value:" + counter.get(name);
        }
    }


}
