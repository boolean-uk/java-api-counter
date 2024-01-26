package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("counter")
public class CounterController {
    private List<Counter> counters;
    private int counter;

    public CounterController(){
        this.counter = 0;
        this.counters = new ArrayList<>();
    }

    @GetMapping
    public int getCounter(){
        return this.counter;
    }

    @GetMapping("increment")
    public int increase(){
        this.counter +=1;
        return getCounter();
    }

    @GetMapping("decrement")
    public int decrease(){
        this.counter -=1;
        return getCounter();
    }

//    @GetMapping("/number/{jokeIndex}/line1")
//    public String getSpecificJokeLine1(@PathVariable(name = "jokeIndex") int jokeIndex) {
    @GetMapping("custom/{name}")
    public String getCounterByName(@PathVariable String name){

        for (Counter counter : counters){
            if(counter.getName().equals(name)){
                return "Count of " + name + " is: " + counter.getCount();
            }
        }
        counters.add(new Counter(name));
        return "Counter named: " + name + " created";
    }

    @GetMapping("custom/{name}/increment")
    public String increaseWithName(@PathVariable String name){
        for (Counter counter : counters){
            if(counter.getName().equals(name)){
                counter.setCount(counter.getCount() +1);
                return "Count of " + name + " is: " + counter.getCount();
            }
        }
        counters.add(new Counter(name, 1));
        return "Counter named: " + name + " created with initial value 1";
    }

    @GetMapping("custom/{name}/decrement")
    public String decreaseWithName(@PathVariable String name){

        for (Counter counter : counters){
            if(counter.getName().equals(name)){
                counter.setCount(counter.getCount() - 1);
                return "Count of " + name + " is: " + counter.getCount();
            }
        }
        counters.add(new Counter(name, -1));
        return "Counter named: " + name + " created with initial value -1";
    }
}
