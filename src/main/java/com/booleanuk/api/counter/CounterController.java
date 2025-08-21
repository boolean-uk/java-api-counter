package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/counter")
public class CounterController {

    HashMap<String, Integer> map = new HashMap<>();

    String defaultName = "Counter";
    int counter = 0;

    @GetMapping
    public String getCounterValue() {
        return "Counter Value: " + counter;
    }

    @GetMapping("/increment")
    public String incrementCounter() {
        counter = counter + 1;
        return "Counter Value: " + counter;
    }

    @GetMapping("/decrement")
    public String decrementCounter() {
        counter = counter - 1;
        return "Counter Value: " + counter;
    }

    // -- EXTENSIONS -- //

    @GetMapping("/custom/{name}")
    public String createCustomCounter(@PathVariable String name) {
        if (map.containsKey(name)) {
            return name + ": " + map.get(name);
        }

        map.put(name, 0);
        return name + ": " + counter;
    }

    @GetMapping("/custom/{name}/increment")
    public String incrementCustomCounter(@PathVariable String name) {
        if (map.containsKey(name)) {
            int value = map.get(name) + 1;
            map.replace(name, value);

            return name + ": " + value;
        }

        map.put(name, 1);
        return name + ": " + 1;
    }

    @GetMapping("/custom/{name}/decrement")
    public String decrementCustomCounter(@PathVariable String name) {
        if (map.containsKey(name)) {
            int value = map.get(name) + -1;
            map.replace(name, value);

            return name + ": " + value;
        }

        map.put(name, -1);
        return name + ": " + -1;
    }
}
