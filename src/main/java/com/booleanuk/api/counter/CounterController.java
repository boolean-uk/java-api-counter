package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("counter")
public class CounterController {
    private int count;
    HashMap<String, Integer> names;

    public CounterController(){
        this.count = 0;
        names = new HashMap<>();
    }

    @GetMapping
    public String getCount(){
        return "" + count;
    }

    @GetMapping("increment")
    public String increment(){
        count++;
        return "" + count;
    }

    @GetMapping("decrement")
    public String decrement(){
        count--;
        return "" + count;
    }

    @GetMapping("custom/{name}")
    public String custom(@PathVariable String name){
        if(!names.containsKey(name)){
            names.put(name, 0);
        }
        return name + " " + names.get(name);
    }

    @GetMapping("custom/{name}/increment")
    public String customIncrement(@PathVariable String name){
        names.put(name, names.getOrDefault(name,0) + 1 );
        return name + " " + names.get(name);
    }

    @GetMapping("custom/{name}/decrement")
    public String customDecrement(@PathVariable String name){
        names.put(name, names.getOrDefault(name,0) - 1 );
        return name + " " + names.get(name);
    }
}
