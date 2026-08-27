package com.booleanuk.api.counter;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter")
public class CounterController {

    private int coreCount;
    private Map<String, Integer> extentionCounters;

    public CounterController(){
        this.coreCount = 0;
        this.extentionCounters = new HashMap<String, Integer>();
    }

    @GetMapping
    public int getCount(){
        return this.coreCount;
    }

    @GetMapping("/increment")
    public int getIncrease(){
        this.coreCount++;
        return this.coreCount;
    }

    @GetMapping("/decrement")
    public int getDecrease(){
        this.coreCount--;
        return this.coreCount;
    }

    @GetMapping("/custom/{name}")
    public int getCustomCount(@PathVariable String name){
        if(this.extentionCounters.containsKey(name)){
            return this.extentionCounters.get(name);
        }
        else{
            this.extentionCounters.put(name, 0);
            return 0;
        }
    }

    @GetMapping("/custom/{name}/increment")
    public int getCustomIncrease(@PathVariable String name){
        if(this.extentionCounters.containsKey(name)){
            int oldPlus = this.extentionCounters.get(name) + 1;
            this.extentionCounters.replace(name, oldPlus);
            return this.extentionCounters.get(name);
        }
        else{
            this.extentionCounters.put(name, 1);
            return 1;
        }
    }

    @GetMapping("/custom/{name}/decrement")
    public int getCustomDecrease(@PathVariable String name){
        if(this.extentionCounters.containsKey(name)){
            int oldMinus = this.extentionCounters.get(name) - 1;
            this.extentionCounters.replace(name, oldMinus);
            return this.extentionCounters.get(name);
        }
        else{
            this.extentionCounters.put(name, -1);
            return -1;
        }
    }

}
