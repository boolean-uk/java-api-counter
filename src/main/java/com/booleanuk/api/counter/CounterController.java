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
    private HashMap<String, Integer> nameCounter;

    public CounterController() {
        this.counter = 0;
        this.nameCounter = new HashMap<>();
    }

    @GetMapping
    public int getCounter() {
        return this.counter;
    }

    @GetMapping("/increment")
    public int increment() {
        this.counter = counter + 1;
        return counter;
    }

    @GetMapping("/decrement")
    public int decrement() {
        this.counter = counter - 1;
        return counter;
    }

    @GetMapping("/custom/{name}")
    public int customNameCounter(@PathVariable String name) {
        if (! nameCounter.containsKey(name)) {
            nameCounter.put(name, 0);
            return nameCounter.get(name);
        }
        return nameCounter.get(name);

    }

    @GetMapping("/custom/{name}/increment")
    public int customNameIncrement(@PathVariable String name) {
        if (nameCounter.containsKey(name)) {
            nameCounter.replace(name, nameCounter.get(name) + 1);
            return nameCounter.get(name);
        }
        nameCounter.put(name, 1);
        return nameCounter.get(name);
    }

    @GetMapping("/custom/{name}/decrement")
    public int customnameDecrement(@PathVariable String name) {
        if (nameCounter.containsKey(name)) {
            nameCounter.replace(name, nameCounter.get(name) - 1);
            return nameCounter.get(name);
        }
        nameCounter.put(name, -1);
        return nameCounter.get(name);
    }

}
