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
    private final HashMap<String, Integer> counters= new HashMap<>();

    @GetMapping
    public int getCounter(){
        return this.counter;
    }

    @GetMapping("/increment")
    public int increment(){
        return ++this.counter;
    }

    @GetMapping("/decrement")
    public int decrement(){
        return --this.counter;
    }

    @GetMapping("/custom/{counterName}")
    public int getCustomCounter(@PathVariable String counterName){
        if (counters.getOrDefault(counterName, -1).equals(-1))
        {
            counters.put(counterName, 0);
        }
        return counters.get(counterName);
    }

    @GetMapping("/custom/{counterName}/increment")
    public int incrementCustomCounter(@PathVariable String counterName){
        return counters.merge(counterName, 1, Integer::sum);
    }

    @GetMapping("/custom/{counterName}/decrement")
    public int decrementCustomCounter(@PathVariable String counterName){
        return counters.merge(counterName, -1, Integer::sum);
    }
}
