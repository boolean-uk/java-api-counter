package com.booleanuk.api.counter;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@ResponseBody
public class CounterController {
    private Counter counter;
    private HashMap<String, Counter> names;

    public CounterController(){
        this.counter = new Counter();
        this.names = new HashMap<>();
    }

    @GetMapping("/counter")
    public int Counter(){
        return this.counter.getCount();
    }

    @GetMapping("/counter/increment")
    public int incrementCount(){
        return this.counter.incrementCount();
    }
    @GetMapping("/counter/decrement")
    public int decrementCounter(){
        return this.counter.decrementCount();
    }

    @GetMapping("/counter/custom/{name}")
    public int CustomCounter(@PathVariable String name){
        if(!names.containsKey(name)){
            Counter counter = new Counter();
            names.put(name, counter);
            System.out.println("NEW ENTRY IN LIST");
            return names.get(name).getCount();
        }
        System.out.println("ENTRY ALREADY IN LIST");
        return names.get(name).getCount();
    }

    @GetMapping("/counter/custom/{name}/increment")
    public int CustomCounterIncrement(@PathVariable String name){
        if(!names.containsKey(name)){
            Counter counter = new Counter();
            names.put(name, counter);
            System.out.println("NEW ENTRY IN LIST (INCREMENT)");
            names.get(name).setCount(1);
            return names.get(name).getCount();
        }
        System.out.println("ENTRY ALREADY IN LIST, INCREMENTING");
        names.get(name).setCount(names.get(name).getCount()+1);
        return names.get(name).getCount();
    }
    @GetMapping("/counter/custom/{name}/decrement")
    public int CustomCounterDecrement(@PathVariable String name){
        if(!names.containsKey(name)){
            Counter counter = new Counter();
            names.put(name, counter);
            System.out.println("NEW ENTRY IN LIST (DECREMENT)");
            names.get(name).setCount(-1);
            return names.get(name).getCount();
        }
        System.out.println("ENTRY ALREADY IN LIST, INCREMENTING");
        names.get(name).setCount(names.get(name).getCount()-1);
        return names.get(name).getCount();
    }


}
