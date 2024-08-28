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
    HashMap<String, Integer> customCounter;

    public CounterController() {
        this.counter = 0;
        this.customCounter = new HashMap<>();
    }

    @GetMapping("/increment")
    public String incrementCounter() {
        this.counter++;
        return toString();
    }

    public int getCounter() {
        return this.counter;
    }

    @GetMapping()
    @Override
    public String toString() {
        return "Current value of counter = " + this.counter;
    }

    @GetMapping("/decrement")
    public String decrementCounter() {
        this.counter--;
        return toString();
    }

    @GetMapping("/custom/{id}")
    public String getCustomCounter(@PathVariable String id) {
        checkIfCounterExist(id, 0);
        return customCounter.get(id).toString();
    }

    @GetMapping("/custom/{id}/increment")
    public String incrementCustomCounter(@PathVariable String id) {
        if(checkIfCounterExist(id, 1)) {
            customCounter.put(id, customCounter.get(id) + 1);
        }
        return customCounter.get(id).toString();
    }

    @GetMapping("/custom/{id}/decrement")
    public String decrementCustomCounter(@PathVariable String id) {
        if(checkIfCounterExist(id, -1)) {
            customCounter.put(id, customCounter.get(id) - 1);
        }
        return customCounter.get(id).toString();
    }

    private boolean checkIfCounterExist(String id, Integer init) {
        if(customCounter.containsKey(id)) {
            return true;
        }else {
            customCounter.put(id, init);
            return false;
        }
    }


}
