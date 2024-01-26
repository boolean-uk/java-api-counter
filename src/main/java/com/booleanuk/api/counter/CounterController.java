package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("counter")
public class CounterController {
    private int universalCounter;
    private HashMap<String, Integer> counters;

    public CounterController() {
            universalCounter = 0;
            counters = new HashMap<>();
    }

    @GetMapping("/increment")
    public String increseCounter() {
        universalCounter++;
        return universalCounter + "";
    }

    @GetMapping("/decrement")
    public String decreseCounter() {
        universalCounter--;
        return universalCounter + "";
    }

    @GetMapping("custom/{name}")
    public String getNamedCounter(@PathVariable String name) {
        if(counters.containsKey(name)) {
            return counters.get(name) + "";
        }
        counters.put(name, 0);
        return "0";
    }

    @GetMapping("custom/{name}/increment")
    public String increaseNamedCounter(@PathVariable String name) {
        if(counters.containsKey(name)) {
            int newValue = counters.get(name) + 1;
            counters.put(name, newValue);
            return newValue + "";
        }
        counters.put(name, 1);
        return "1";
    }

    @GetMapping("custom/{name}/decrement")
    public String decreaseNamedCounter(@PathVariable String name) {
        if(counters.containsKey(name)) {
            int newValue = counters.get(name) - 1;
            counters.put(name, newValue);
            return newValue + "";
        }
        counters.put(name, -1);
        return "-1";
    }
}
