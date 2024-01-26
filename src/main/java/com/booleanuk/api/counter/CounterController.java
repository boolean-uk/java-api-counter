package com.booleanuk.api.counter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

@RestController
@RequestMapping("/counter")
public class CounterController {
    private int counter = 0;
    @GetMapping
    public int getCounter() {
        return counter;
    }
    @GetMapping("/increment")
    public int incrementCounter() {
        counter++;
        return counter;
    }
    @GetMapping("/decrement")
    public int decrementCounter() {
        counter--;
        return counter;
    }
    private HashMap<String, Integer> counters = new HashMap<>();

    @GetMapping("/custom/{name}")
    public int getCustomCounter(@PathVariable String name) {
        return counters.getOrDefault(name, 0);
    }
    @GetMapping("/custom/{name}/increment")
    public int incrementCustomCounter(@PathVariable String name) {
        int currentCounterValue = counters.getOrDefault(name, 0);
        currentCounterValue++;
        counters.put(name, currentCounterValue);
        return currentCounterValue;
    }
    @GetMapping("/custom/{name}/decrement")
    public int decrementCustomCounter(@PathVariable String name) {
        int currentCounterValue = counters.getOrDefault(name, 0);
        currentCounterValue--;
        counters.put(name, currentCounterValue);
        return currentCounterValue;
    }

}
