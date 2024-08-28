package com.booleanuk.api.counter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/counter")
public class CounterController {
    //private int counter;
    private Counter counter;
    private ArrayList<Counter> counterList;

    public CounterController(Counter counter){
        this.counter = counter;
        this.counterList = new ArrayList<>();
        counterList.add(counter);
    }


    @GetMapping()
    public int getCounter(){
        return counter.getCounter();
    }

    @GetMapping("/increment")
    public int increment(){
        counter.increment();
        return counter.getCounter();
    }


    @GetMapping("/decrement")
    public int decrement(){
        counter.decrement();
        return counter.getCounter();
    }


    @GetMapping("/custom/{name}")
    public String customCounter(@PathVariable String name){
        for(Counter c: counterList){
            if(c.getName().equals(name)) {
                return "Counter already exists with counter: " + counter.getCounter();
            }
        }

        Counter newCounter = new Counter(name);
        counterList.add(newCounter);
        return "Created new counter for " + newCounter.getName() + " with a counter of: " + newCounter.getCounter();
    }


    @GetMapping("/custom/{name}/increment")
    public String customIncrement(@PathVariable String name){

        for(Counter c: counterList){
            if(c.getName().equals(name)) {
                c.increment();
                return "Counter for " + c.getName() + "incremented by one, new value: " + c.getCounter();
            }
        }
        Counter newCounter = new Counter(name);
        newCounter.increment();
        counterList.add(newCounter);
        return "Created new counter for:  " + newCounter.getName() + "incremented by one, new value: " + newCounter.getCounter();

    }

    @GetMapping("/custom/{name}/decrement")
    public String customDecrement(@PathVariable String name){
        for(Counter c: counterList){
            if(c.getName().equals(name)) {
                c.decrement();
                return "Counter for " + c.getName() + " decremented by one, new value: " + c.getCounter();
            }
        }
        Counter newCounter = new Counter(name);
        newCounter.decrement();
        counterList.add(newCounter);
        return "Created new counter for:  " + newCounter.getName() + "decrement by one, new value: " + newCounter.getCounter();
    }







}
