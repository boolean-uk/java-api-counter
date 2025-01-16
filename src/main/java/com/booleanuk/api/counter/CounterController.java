package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("counter") //http://localhost:4000/counter
public class CounterController {

    private int number;
    private String name;
    private HashMap<String, Integer> names = new HashMap<>();

    public CounterController(){
        this.number = 0;
    }

    @GetMapping
    public int getNumber(){
        return this.number;
    }

    @GetMapping("increment")
    public int increment(){
        number++;
        return number;
    }

    @GetMapping("decrement")
    public int decrement(){
        number--;
        return number;
    }

    @GetMapping("custom/{name}")
    public int checkName(@PathVariable String name){
        if (names.containsKey(name)){
            return names.get(name);
        }
        names.put(name, number);
        return names.get(name);
    }

    @GetMapping("custom/{name}/increment")
    public int incrementName(@PathVariable String name){
        if (names.containsKey(name)){
            names.put(name, names.get(name) + 1);
            return names.get(name);
        }
        names.put(name, 1);
        return names.get(name);
    }

    @GetMapping("custom/{name}/decrement")
    public int decrementName(@PathVariable String name){
        if (names.containsKey(name)){
            names.put(name, names.get(name) - 1);
            return names.get(name);
        }
        names.put(name, -1);
        return names.get(name);
    }

}
