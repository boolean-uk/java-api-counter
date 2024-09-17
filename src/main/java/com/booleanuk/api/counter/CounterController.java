package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/counter")
public class CounterController {
    private int value;
    private final HashMap<String,Integer> customCounters;

    public CounterController() {
        value = 0;
        customCounters = new HashMap<>();
    }

    @GetMapping
    public String getCounter() {
        return "<h1 style=font-size:160px;text-align:center>Current value: " + this.value + "<h1>";
    }

    @GetMapping("/increment")
    public String increment(){
        return "<h1 style=font-size:128px;text-align:center>Value increased by 1 and is now: " + (++this.value) + "<h1>";
    }

    @GetMapping("/decrement")
    public String decrement(){
        return "<h1 style=font-size:128px;text-align:center>Value decreased by 1 and is now: " + (--this.value) + "<h1>";
    }

    @GetMapping("/custom/{name}")
    public String getCustom(@PathVariable String name){
        Integer value = this.customCounters.getOrDefault(name,null);
        if (value == null){
            value = 0;
            this.customCounters.put(name,value);
        }
        return "<h1 style=font-size:160px;text-align:center>Current value: " + value + "<h1>";
    }

    @GetMapping("/custom/{name}/increment")
    public String incrementCustom(@PathVariable String name){
        Integer value = this.customCounters.getOrDefault(name,null);
        if (value == null){
            value = 1;
            this.customCounters.put(name,value);
        } else {
            value++;
            this.customCounters.put(name,value);
        }
        return "<h1 style=font-size:128px;text-align:center>Value increased by 1 and is now: " + value + "<h1>";
    }

    @GetMapping("/custom/{name}/decrement")
    public String decrementCustom(@PathVariable String name){
        Integer value = this.customCounters.getOrDefault(name,null);
        if (value == null){
            value = -1;
            this.customCounters.put(name,value);
        } else {
            value--;
            this.customCounters.put(name,value);
        }
        return "<h1 style=font-size:128px;text-align:center>Value decreased by 1 and is now: " + value + "<h1>";
    }
}
