package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("counter")
public class CounterController {
    private int counterValue;
    private HashMap<String, Integer> customCounters;

    public CounterController()
    {
        this.counterValue = 0;
        this.customCounters = new HashMap<>();
    }

    @GetMapping
    public int getCount()
    {
        return this.counterValue;
    }

    @GetMapping("increment")
    public int incrementValue()
    {
        this.counterValue += 1;
        return this.counterValue;
    }

    @GetMapping("decrement")
    public int decrementValue()
    {
        this.counterValue -= 1;
        return this.counterValue;
    }

    @GetMapping("custom/{name}")
    public int getCustomCounter(@PathVariable String name)
    {
        if(this.customCounters.containsKey(name)) {
        }
        else {
            this.customCounters.put(name, 0);
        }
        return this.customCounters.get(name);
    }

    @GetMapping("custom/{name}/increment")
    public int incrementCustomCounter(@PathVariable String name)
    {
        if(this.customCounters.containsKey(name)) {
            this.customCounters.put(name,this.customCounters.get(name)+1);
        }
        else {
            this.customCounters.put(name, 1);
        }
        return this.customCounters.get(name);
    }

    @GetMapping("custom/{name}/decrement")
    public int decrementCustomCounter(@PathVariable String name)
    {
        if(this.customCounters.containsKey(name)) {
            this.customCounters.put(name,this.customCounters.get(name)-1);
        }
        else {
            this.customCounters.put(name, -1);
        }
        return this.customCounters.get(name);
    }
}
