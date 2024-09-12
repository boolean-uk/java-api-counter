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
    private HashMap<String, Integer> nameCounter = new HashMap<>();


    @GetMapping
    public int getCounter(){
        return this.counter;
    }

    @GetMapping("/increment")
    public int getIncrement(){
        this.counter++;
        return this.counter;
    }

    @GetMapping("/decrement")
    public int getDecrement(){
        this.counter--;
        return this.counter;
    }

    @GetMapping("/custom/{name}")
    public int getNameCounter(@PathVariable String name){
        if (!nameCounter.containsKey(name)){
            this.counter = 0;
            nameCounter.put(name, counter);
        }
        return nameCounter.get(name);
    }

    @GetMapping("/custom/{name}/increment")
    public int getSpesificNameCounterIncrement(@PathVariable String name){
        if (!nameCounter.containsKey(name)){
            this.counter=1;
            nameCounter.put(name, this.counter);
            return nameCounter.get(name);
        }
        nameCounter.put(name, counter++);
        return nameCounter.get(name);
    }

    @GetMapping("/custom/{name}/decrement")
    public int getSpesificNameCounterDecrement(@PathVariable String name){
        if (!nameCounter.containsKey(name)){
            this.counter=-1;
            nameCounter.put(name, this.counter);
            return nameCounter.get(name);
        }
        nameCounter.put(name, counter--);
        return nameCounter.get(name);
    }
}
