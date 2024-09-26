package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/counter")
public class CounterController {

    private int counter;
    private HashMap<String,Integer> counters;

    public CounterController(){
        this.counters = new HashMap<>();
       //this.counter=0;
    }
    @GetMapping
    public int getCounter(){
        return this.counter;
    }
    @GetMapping("/increment")
    public int getIncrementedCounter(){
        return ++this.counter;
    }

    @GetMapping("/decrement")
    public int getDecrementCounter(){
        return --this.counter;
    }

    @GetMapping("/custom/{name}")
    public int getCustomCounter(@PathVariable(name="name") String name){

        if(!this.counters.containsKey(name)){
           this.counters.put(name,0);

        }

        return this.counters.get(name);
    }
    @GetMapping("/custom/{name}/increment")
    public int getCustomIncrementCounter(@PathVariable(name="name") String name){

        if(!this.counters.containsKey(name)){
            this.counters.put(name,0);

        }
        int counterIncreased = this.counters.get(name)+1;
        this.counters.put(name,counterIncreased);
        return this.counters.get(name);
    }

    @GetMapping("/custom/{name}/decrement")
    public int getCustomDecrementCounter(@PathVariable(name="name") String name){

        if(!this.counters.containsKey(name)){
            this.counters.put(name,0);

        }
        int counterDecreased = this.counters.get(name)-1;
        this.counters.put(name,counterDecreased);
        return this.counters.get(name);
    }

}
