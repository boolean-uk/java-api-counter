package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class CounterController {
    private int counter=0;
    private HashMap<String, Integer> counters=new HashMap<>();


    public CounterController(){

    }
    @GetMapping("/counter")
    public String getCounter(){
        return String.valueOf(this.counter);
    }

    @GetMapping("/counter/increment")
    public String getIcrement(){
        this.counter+=1;
        return String.valueOf(this.counter);
    }

    @GetMapping("/counter/decrement")
    public String getDecrement(){
        this.counter-=1;
        return String.valueOf(this.counter);
    }

    @GetMapping("counter/custom/{name}")
    public String getCustom(@PathVariable String name){

        if (!counters.containsKey(name)){
            counters.put(name, 0);

        }
        return String.valueOf(counters.get(name));
    }

    @GetMapping("counter/custom/{name}/increment")
    public String getCustomIncrement(@PathVariable String name){
        if (!counters.containsKey(name)){
            counters.put(name, 1);
            return String.valueOf(counters.get(name));
        }
        counters.replace(name, counters.get(name)+1);
        return String.valueOf(counters.get(name));
    }

    @GetMapping("counter/custom/{name}/decrement")
    public String getCustomDecrement(@PathVariable String name){
        if (!counters.containsKey(name)){
            counters.put(name, -1);
            return String.valueOf(counters.get(name));
        }
        counters.replace(name, counters.get(name)-1);
        return String.valueOf(counters.get(name));
    }



}
