package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("counter")
public class CounterController {

private HashMap<String, Integer> namesMap = new HashMap<>();
private int counter = 0;

    @GetMapping
    public int getCounter(){
        return this.counter;
    }

    @GetMapping("/increment")
    public int incrementCounter(){
        return this.counter++;
    }

    @GetMapping("/decrement")
    public int decrementCounter(){
        return this.counter--;
    }

    @GetMapping("/custom/{name}")
    public int nameCounter(@PathVariable String name){
        if(!namesMap.containsKey(name)){
            counter = 0;
            namesMap.put(name, counter);
        }
        return namesMap.get(name);
    }

    @GetMapping("/custom/{name}/increment")
    public int getNameIncrement(@PathVariable String name){
        if(!namesMap.containsKey(name)){
            counter = 1;
            namesMap.put(name, counter);
            return namesMap.get(name);
        }
        namesMap.put(name,counter++);
        return namesMap.get(name);
    }

    @GetMapping("/custom/{name}/decrement")
    public int getNameDecrement(@PathVariable String name){
        if(!namesMap.containsKey(name)){
            counter = 1;
            namesMap.put(name, counter);
            return namesMap.get(name);
        }
        namesMap.put(name,counter--);
        return namesMap.get(name);
    }
}
