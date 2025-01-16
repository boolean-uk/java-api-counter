package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("counter") // http://localhost:4000/counter
public class CounterController {
    private int number;
    private HashMap<String, Integer> listOfSpecificCounters;

    public CounterController(){
        this.number = 0;
        this.listOfSpecificCounters = new HashMap<>();
    }

    @GetMapping
    public String welcomeMessage(){
        return "Welcome to the counter-page!";
    }

    @GetMapping("current")
    public int getCurrentValue(){
        return this.number;
    }

    @GetMapping("increment")
    public int increment(){
        return ++this.number;
    }

    @GetMapping("decrement")
    public int decrement(){
        return --this.number;
    }


    // EXTENSION 1
    @GetMapping("custom/{name}")
    public int getSpecificCurrentValue(@PathVariable String name){
        if(this.listOfSpecificCounters.containsKey(name)){
            return this.listOfSpecificCounters.get(name);
        } else {
            this.listOfSpecificCounters.put(name, 0);
            return 0;
        }
    }

    // EXTENSION 2
    @GetMapping("custom/{name}/increment")
    public int incrementSpecificCurrentValue(@PathVariable String name){
        if(this.listOfSpecificCounters.containsKey(name)){
            this.listOfSpecificCounters.put(name, this.listOfSpecificCounters.get(name) + 1);
            return this.listOfSpecificCounters.get(name);
        } else {
            this.listOfSpecificCounters.put(name, 1);
            return 1;
        }
    }

    // EXTENSION 3
    @GetMapping("custom/{name}/decrement")
    public int decrementSpecificCurrentValue(@PathVariable String name){
        if(this.listOfSpecificCounters.containsKey(name)){
            this.listOfSpecificCounters.put(name, this.listOfSpecificCounters.get(name) - 1);
            return this.listOfSpecificCounters.get(name);
        } else {
            this.listOfSpecificCounters.put(name, -1);
            return -1;
        }
    }
}
