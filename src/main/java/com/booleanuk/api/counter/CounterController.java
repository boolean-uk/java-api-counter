package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

@RestController
@RequestMapping("counter")
public class CounterController {

    private HashMap<String, Integer> counterMap;
    private int counter;

    public CounterController(){
        counter = 0;
        counterMap = new HashMap<>();
    }

    @GetMapping()
    public String getCounter(){
        return "counter:" + counter;
    }

    @GetMapping("/increment")
    public int incrementCounter(){
        return counter += 1;
    }

    @GetMapping("/decrease")
    public int decreaseCounter(){
        return counter -= 1;
    }

    @GetMapping("/custom/{name}")
    public int getCounterByName(@PathVariable String name){
        if(!counterMap.containsKey(name)){
            counterMap.put(name, 0);
        }
        return counterMap.get(name);

    }

    @GetMapping("/custom/{name}/increment")
    public int getCounterByNameAndIncrement(@PathVariable String name){
        if(counterMap.containsKey(name)){
            counterMap.replace(name, counterMap.get(name)+1);

        }
        else
            counterMap.put(name, 1);

        return counterMap.get(name);

    }

    @GetMapping("/custom/{name}/decrease")
    public int getCounterByNameAndDecrease(@PathVariable String name){
        if(counterMap.containsKey(name)){
            counterMap.replace(name, counterMap.get(name)-1);

        }
        else
            counterMap.put(name, -1);

        return counterMap.get(name);

    }
}
