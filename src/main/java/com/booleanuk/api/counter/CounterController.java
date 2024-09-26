package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("counter")
public class CounterController {
    private int counter = 0;
    HashMap<String, Integer> mapNames;

    public CounterController(){
//        this.counter = 0;
        this.mapNames = new HashMap<>();
    }

    @GetMapping
    public int getCounter(){
        return this.counter;
    }
    @GetMapping("increment")
    public int getCounterIncrement(){
        counter++;
        return counter;
    }
    @GetMapping("decrement")
    public int getCounterDecrement(){
        counter--;
        return counter;
    }
    @GetMapping("custom/{name}")
    public int getCounter(@PathVariable String name){
        if (mapNames.containsKey(name)){
            mapNames.put(name, mapNames.get(name));
        }else{
            mapNames.put(name,0);
        }
        return mapNames.get(name);
    }
    @GetMapping("custom/{name}/increment")
    public int getCounterIncrement(@PathVariable String name){
        if (mapNames.containsKey(name)){
            mapNames.put(name, mapNames.get(name)+1);
        }else{
            mapNames.put(name,0);
        }
        return mapNames.get(name);
    }
    @GetMapping("custom/{name}/decrement")
    public int getCounterDecrement(@PathVariable String name){
        if (mapNames.containsKey(name)){
            mapNames.put(name, mapNames.get(name)-1);
        }else{
            mapNames.put(name,0);
        }
        return mapNames.get(name);
    }






}
