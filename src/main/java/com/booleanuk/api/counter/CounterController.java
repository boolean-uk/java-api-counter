package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/counter")
public class CounterController {
    private int number;
    private HashMap<String, Integer> namesAndNumbers;

    public CounterController() {
        this.namesAndNumbers = new HashMap<>();
    }

    @GetMapping
    public int getNumber() {
        return this.number;
    }

    @GetMapping("/increment")
    public int incrementAndGetNumber() {
        this.number++;
        return this.number;
    }

    @GetMapping("/decrement")
    public int decrementAndGetNumber() {
        this.number--;
        return this.number;
    }

    @GetMapping("/custom/{name}")
    public int getNameNumber(@PathVariable String name) {
        if(namesAndNumbers.containsKey(name)) {
            return namesAndNumbers.get(name);
        }
        namesAndNumbers.put(name, 0);
        return 0;
    }

    @GetMapping("/custom/{name}/increment")
    public int incrementAndGetNameNumber(@PathVariable String name) {
        if(namesAndNumbers.containsKey(name)) {
            int value = namesAndNumbers.get(name);
            value++;
            namesAndNumbers.put(name, value);
            return value;
        }
        namesAndNumbers.put(name, 1);
        return 1;
    }
}
