package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/counter")
public class CounterController {
    private Integer value;
    private HashMap<String, Integer> customCounters;

    public CounterController() {
        this.customCounters = new HashMap<String, Integer>();
        this.value = 0;
    }

    @GetMapping
    public String getValue() {
        return String.format("<h1>Value: %s</h1>", this.value);
    }

    public HashMap<String, Integer> getCustomCounters() {
        return customCounters;
    }

    @GetMapping("/increment")
    public String increment() {
        return String.format("<h1>Value: %s</h1>", ++this.value);
    }

    @GetMapping("/decrement")
    public String decrement() {
        return String.format("<h1>Value: %s</h1>", --this.value);
    }

    @GetMapping("/custom/{name}")
    public String getCustomValue(@PathVariable String name) {
        this.customCounters.putIfAbsent(name, 0);
        return String.format("<h1>Value: %s</h1>", this.customCounters.get(name));
    }
    @GetMapping("/custom/{name}/increment")
    public String incrementCustomValue(@PathVariable String name) {
        this.customCounters.putIfAbsent(name, 0);
        this.customCounters.put(name,this.customCounters.get(name)+1);
        return String.format("<h1>Value: %s</h1>", this.customCounters.get(name));
    }

    @GetMapping("/custom/{name}/decrement")
    public String decrementCustomValue(@PathVariable String name) {
        this.customCounters.putIfAbsent(name, 0);
        this.customCounters.put(name,this.customCounters.get(name)-1);
        return String.format("<h1>Value: %s</h1>", this.customCounters.get(name));
    }
}
