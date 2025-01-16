package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("counter")
public class CounterController {
    private int counter = 0;
    private HashMap<String, Integer> stringMap = new HashMap<>();

    @GetMapping("value")
    public int getCounter() {
        return this.counter;
    }

    @GetMapping("increment")
    public int increment() {
        counter++;
        return counter;
    }

    @GetMapping("decrement")
    public int decrement() {
        counter--;
        return counter;
    }

    @GetMapping("custom/{name}")
    public int getNameCount(@PathVariable String name) {
        if(!stringMap.containsKey(name)) {
            stringMap.put(name, 0);
        }
        return stringMap.get(name);
    }

    @GetMapping("custom/{name}/increment")
    public int incrementNameCount(@PathVariable String name) {
        if(stringMap.containsKey(name)) {
            stringMap.put(name, stringMap.get(name) + 1);
        } else {
            stringMap.put(name, 1);
        }
        return stringMap.get(name);
    }

    @GetMapping("custom/{name}/decrement")
    public int decrementNameCount(@PathVariable String name) {
        if(stringMap.containsKey(name)) {
            stringMap.put(name, stringMap.get(name) - 1);
        } else {
            stringMap.put(name, -1);
        }
        return stringMap.get(name);
    }
}
