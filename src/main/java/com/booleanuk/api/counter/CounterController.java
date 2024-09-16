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
    HashMap<String, Integer> names;

    public CounterController() {
        this.counter = 0;
        this.names = new HashMap<String, Integer>();
    }

    @GetMapping("increment")
    public String increment() {
        counter ++;
        return Integer.toString(counter);
    }

    @GetMapping("decrement")
    public String decrement() {
        counter --;
        return Integer.toString(counter);
    }

    @GetMapping
    public String getCounter() {
        return Integer.toString(counter);
    }

    @GetMapping("custom/{name}")
    public String Name(@PathVariable String name) {
        if (names.containsKey(name)){
            return  name + ": " + names.get(name);
        }

        names.put(name, 0);

        return  name + ": " + names.get(name);
    }

    @GetMapping("custom/{name}/increment")
    public String incrementName(@PathVariable String name) {
        if (names.containsKey(name)){
            names.put(name,names.get(name)+1);
            return  name + ": " + names.get(name);
        }
        names.put(name,1);

        return  name + ": " + names.get(name);
    }

    @GetMapping("custom/{name}/decrement")
    public String decrementName(@PathVariable String name) {
        if (names.containsKey(name)){
            names.put(name,names.get(name)-1);
            return  name + ": " + names.get(name);
        }
        names.put(name,-1);
        return  name + ": " + names.get(name);
    }



}
