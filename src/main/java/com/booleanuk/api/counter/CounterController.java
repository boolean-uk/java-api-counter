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
    Map<String, Integer> nameMap;

    public CounterController() {
        this.value = 0;
        nameMap = new HashMap<>();
    }

    @GetMapping
    public int getValue() {
        return this.value;
    }
    @GetMapping("/increment")
    public int incrementValue() {
        return ++this.value;
    }
    @GetMapping("/decrement")
    public int decrementValue() {
        return --this.value;
    }

    @GetMapping("/custom/{name}")
    public int getCustomValue(@PathVariable (name = "name") String name) {
        if (this.nameMap.containsKey(name)) {
            return this.nameMap.get(name);
        }
        this.nameMap.put(name, 0);
        return this.nameMap.get(name);
    }

    @GetMapping("/custom/{name}/increment")
    public int incrementCustomValue(@PathVariable (name = "name") String name) {
        if (this.nameMap.containsKey(name)) {
            this.nameMap.put(name, this.nameMap.get(name) + 1);
            return this.nameMap.get(name);
        }
        this.nameMap.put(name, 1);
        return this.nameMap.get(name);
    }
    @GetMapping("/custom/{name}/decrement")
    public int decrementCustomValue(@PathVariable (name = "name") String name) {
        if (this.nameMap.containsKey(name)) {
            this.nameMap.put(name, this.nameMap.get(name) - 1);
            return this.nameMap.get(name);
        }
        this.nameMap.put(name, -1);
        return this.nameMap.get(name);
    }





}
