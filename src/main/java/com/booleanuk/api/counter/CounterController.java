package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/counter")
public class CounterController {
    private int number;
    private HashMap<String, Integer> custom;

    public CounterController(){
        this.number=0;
        this.custom = new HashMap<>();
    }

    @GetMapping
    public int getNumber() {
        return number;
    }

    @GetMapping("/increment")
    public int increment(){
        number++;
        return number;
    }

    @GetMapping("/decrement")
    public int decrement(){
        number--;
        return number;
    }

    // Extension

    @GetMapping("/custom/{name}")
    public int name (@PathVariable String name){
        if (custom.containsKey(name)){
            return custom.get(name);
        }
        custom.put(name, 0);
        return custom.get(name);
    }

    @GetMapping("/custom/{name}/increment")
    public int nameIncrement (@PathVariable String name){
        if (custom.containsKey(name)){
            custom.put(name, custom.get(name)+1);
            return custom.get(name);
        }
        custom.put(name, 1);
        return custom.get(name);
    }

    @GetMapping("/custom/{name}/decrement")
    public int nameDecrement (@PathVariable String name){
        if (custom.containsKey(name)){
            custom.put(name, custom.get(name)-1);
            return custom.get(name);
        }
        custom.put(name, -1);
        return custom.get(name);
    }


}
