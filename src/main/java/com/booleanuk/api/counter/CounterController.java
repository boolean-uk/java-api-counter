package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/counter")
public class CounterController {

    private int counter;
    private Map<String, Integer> counters;

    public CounterController(){
        this.counter = 0;
        this.counters = new HashMap<>();
    }

    @GetMapping()
    public String getCounter() {
        return String.valueOf(this.counter);
    }

    @GetMapping("/increment")
    public String getCounterIncrement() {
        return String.valueOf(this.counter++);
    }

    @GetMapping("/decrement")
    public String getCounterDecrement() {
        return String.valueOf(this.counter--);
    }

    @GetMapping("/custom/{name}")
    public int counterExist(@PathVariable String name){

        if(!this.counters.containsKey(name)) {

            this.counters.put(name, 0);

        }
            return this.counters.get(name);
    }

    @GetMapping("/custom/{name}/increment")
    public int counterIncrement(@PathVariable String name){
        if(this.counters.containsKey(name)){

            this.counters.put(name, this.counters.get(name) + 1);
            return this.counters.get(name);
        } else{

        this.counters.put(name, 1);
        return 1;
        }

    }

    @GetMapping("/custom/{name}/decrement")
    public int counterDecrement(@PathVariable String name){
        if(this.counters.containsKey(name)){

            this.counters.put(name, this.counters.get(name) - 1);
            return this.counters.get(name);
        } else{

            this.counters.put(name, -1);
            return 1;
        }

    }

}
