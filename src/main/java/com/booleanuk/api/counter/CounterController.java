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
    private HashMap<String, Integer> nameCounter;

    public CounterController(){
        this.counter = 0;
        this.nameCounter = new HashMap<>();
    }

    @GetMapping
    public String getCounter() {
        return "<h1> counter: " + this.counter + "<h1>";
    }

    @GetMapping("increment")
    public String incrementCounter() {
        this.counter += 1;
        return "<h1> New counter value: " + this.counter + "<h1>";
    }

    @GetMapping("decrement")
    public String decrementCounter() {
        this.counter -= 1;
        return "<h1> New counter value: " + this.counter + "<h1>";
    }

    @GetMapping("custom/{name}")
    public String getNameCounter(@PathVariable String name){
        if (nameCounter.containsKey(name)){
            return "<h1> Counter value for " + name + " is " + nameCounter.get(name) + "<h1>";
        } else {
            nameCounter.put(name, 0);
            return "<h1> Counter initialized for " + name + " with a value of: " + nameCounter.get(name) + "<h1>";
        }
    }

    @GetMapping("custom/{name}/increment")
    public String incrementNameCounter(@PathVariable String name){
        if (nameCounter.containsKey(name)){
            nameCounter.put(name, nameCounter.get(name)+1);
            return "<h1> Counter value for " + name + " is " + nameCounter.get(name) + "<h1>";
        } else {
            nameCounter.put(name, 1);
            return "<h1> Counter initialized for " + name + " with a value of: " + nameCounter.get(name) + "<h1>";
        }
    }
    @GetMapping("custom/{name}/decrement")
    public String decrementNameCounter(@PathVariable String name){
        if (nameCounter.containsKey(name)){
            nameCounter.put(name, nameCounter.get(name)-1);
            return "<h1> Counter value for " + name + " is " + nameCounter.get(name) + "<h1>";
        } else {
            nameCounter.put(name, -1);
            return "<h1> Counter initialized for " + name + " with a value of: " + nameCounter.get(name) + "<h1>";
        }
    }
}
