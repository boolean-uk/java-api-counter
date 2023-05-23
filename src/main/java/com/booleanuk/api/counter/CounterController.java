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
    private int counter = 0;
    private final Map<String, Integer> counters = new HashMap<>();

    //Get requesto to http://localhost:4000/counter
    @GetMapping
    public int getCounter(){
        return this.counter;
    }

    @GetMapping("/increment")
    public int incrementCounter(){
        return ++this.counter;
    }

    @GetMapping("/decrement")
    public int decrementCounter(){
        return --this.counter;
    }

    @GetMapping("/custom/{name}")
    public int getCustomCounter(@PathVariable(name = "name") String name) {
        if (counters.containsKey(name)) {
            return counters.get(name);
        } else {
            counters.put(name, 0);
            return 0;
        }
    }
        @GetMapping("/custom/{name}/increment")
        public int incrementCustomCounter(@PathVariable(name = "name") String name){
            if(counters.containsKey(name)){
                int currentValue = counters.get(name);
                int newValue = currentValue + 1;
                counters.put(name, newValue);
                return newValue;
            } else{
                counters.put(name, 1);
                return 1;
            }
        }

        @GetMapping("/custom/{name}/decrement")
        public int decrementCustomCounter(@PathVariable(name = "name") String name){
            if(counters.containsKey(name)){
                int currentValue = counters.get(name);
                int newValue = currentValue - 1;
                counters.put(name, newValue);
                return newValue;
            } else{
                counters.put(name, -1);
                return -1;
            }
        }

    }






