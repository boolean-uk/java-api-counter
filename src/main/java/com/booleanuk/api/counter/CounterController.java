package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("counter")
public class CounterController {
    private int counter = 0;
    private HashMap<String, Integer> nameCount;
    public CounterController() {
        this.nameCount = new HashMap<>();
    }

    @GetMapping
    public int getCount(){
      return this.counter;
    }

    @GetMapping("increment")
    public int increment(){
        this.counter++;
        return this.counter;
    }

    @GetMapping("decrement")
    public int decrement(){
        this.counter--;
        return this.counter;
    }

    @GetMapping("custom/{name}")
    public int customValue(@PathVariable(name = "name") String name){
        if (!this.nameCount.containsKey(name))  {
            this.nameCount.put(name, 0);
            return this.nameCount.get(name);
        }
        return this.nameCount.get(name);
    }
    @GetMapping("custom/{name}/increment")
    public int customValueIncrement(@PathVariable(name = "name") String name){
        if (!this.nameCount.containsKey(name))  {
            this.nameCount.put(name, 0);
            return this.nameCount.get(name);
        }
        this.nameCount.put(name, nameCount.get(name)+1);
        return this.nameCount.get(name);
    }

    @GetMapping("custom/{name}/decrement")
    public int customValueDecrement(@PathVariable(name = "name") String name){
        if (!this.nameCount.containsKey(name))  {
            this.nameCount.put(name, 0);
            return this.nameCount.get(name);
        }
        this.nameCount.put(name, nameCount.get(name)-1);
        return this.nameCount.get(name);
    }
}
