package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

//Core
@RestController
public class CounterController {
    private int counter;
    private int customCounter;
    HashMap<String, Integer> users;

    CounterController(){
        counter = 0;
        customCounter = 0;
        users = new HashMap<>();
    }

    @GetMapping("counter")
    public String getCounter(){
        return "" + this.counter;
    }

    @GetMapping("counter/increment")
    public String incrementCounter(){
        counter++;

        return "" + counter;
    }

    @GetMapping("counter/decrement")
    public String decrementCounter(){
        counter--;

        return "" + counter;
    }

    //Extension
    @GetMapping(value = "counter/custom/{name}")
    public String getCustomCounter(@PathVariable String name){
        if (!users.containsKey(name)){
            users.put(name, customCounter);

            return "" + users.get(name);
        }
        else {
            return "" + users.get(name);
        }
    }

    @GetMapping("counter/custom/{name}/increment")
    public String incrementCustomCounter(@PathVariable String name){
        if (!users.containsKey(name)){
            users.put(name, customCounter + 1);
        }
        else {
            users.put(name, users.get(name) + 1);
        }

        return "" + users.get(name);
    }

    @GetMapping("counter/custom/{name}/decrement")
    public String decrementCustomCounter(@PathVariable String name){
        if (!users.containsKey(name)) {
            users.put(name, customCounter - 1);
        }
        else {
            users.put(name, users.get(name) - 1);
        }

        return "" + users.get(name);
    }

}
