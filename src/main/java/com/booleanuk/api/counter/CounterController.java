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
    public int counterIncrease() {
        return this.counter += 1;
    }

    @GetMapping("/decrement")
    public int counterDecrement() {
        return this.counter -= 1;
    }

    @GetMapping("/custom/{name}")
    public int counterCustom(@PathVariable(name = "name") String name) {
        if (!this.nameCounter.containsKey(name)) {
            this.nameCounter.put(name, 0);
            return this.nameCounter.get(name);
        }
        return this.nameCounter.get(name);
    }

    @GetMapping("/custom/{name}/increment")
    public int counterCustomIncrement(@PathVariable(name = "name") String name) {
        if (this.nameCounter.containsKey(name)) {
            int currentValue = this.nameCounter.get(name);
            int newValue = currentValue + 1;
            this.nameCounter.put(name, newValue);
            return newValue;
        } else {
            this.nameCounter.put(name, 1);
            return this.nameCounter.get(name);
        }
    }
    @GetMapping("/custom/{name}/decrement")
    public int counterCustomDecrement(@PathVariable(name = "name") String name) {
        if (this.nameCounter.containsKey(name)) {
            int currentValue = this.nameCounter.get(name);
            int newValue = currentValue - 1;
            this.nameCounter.put(name, newValue);
            return newValue;
        } else {
            this.nameCounter.put(name, -1);
            return this.nameCounter.get(name);
        }
    }
}

