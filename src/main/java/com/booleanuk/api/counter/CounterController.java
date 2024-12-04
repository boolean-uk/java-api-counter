package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/counter")
public class CounterController {

    private int counter;
    private Map<String, Integer> newCounterMap;

    public CounterController() {
        this.counter = 0;
        newCounterMap = new HashMap<>();

    }

    //Core exercise
    @GetMapping
    public int counter() {
        return this.counter;
    }

    @GetMapping("/increment")
    public int incrementCounter() {
        this.counter++;
        return this.counter;
    }
    @GetMapping("/decrement")
    public int decrementCounter() {
        this.counter--;
        return this.counter;
    }

    //Extension Exercise
    @GetMapping("/custom/{name}")
    public int custom(@PathVariable (name = "name") String name) {
        if(!newCounterMap.containsKey(name)) { //If name does not exist in hashmap
            this.counter = 0; //Counter set to 0
            newCounterMap.put(name, this.counter); //Adds name and counter set to the hashmap
            return this.counter; //Returns counter
        }

        return newCounterMap.get(name); //Else gets the counter of the name provided

    }
    @GetMapping("/custom/{name}/increment")
    public int customIncrement(@PathVariable (name = "name") String name) {

        if(!newCounterMap.containsKey(name)) { //If name does not exist in hashmap
            this.counter  = 1; //Initial value set to 1
            newCounterMap.put(name, this.counter); //Add to the hashmap with value set to 1
        }
        //If name does exist
        this.counter++; //Increment value by 1
        newCounterMap.put(name, this.counter); //Adds the name and incremented value to hashmap
        return this.counter; //Returns the value
    }
    @GetMapping("/custom/{name}/decrement")
    public int customDecrement(@PathVariable (name = "name") String name) {

        if(!newCounterMap.containsKey(name)) { //If name does not exist in hashmap
            this.counter  = -1; //Initial value set to -1
            newCounterMap.put(name, this.counter); //Add to the hashmap with value set to -1
        }
        //If name does exist
        this.counter--; //Decrement value by 1
        newCounterMap.put(name, this.counter); //Adds the name and decremented value to hashmap
        return this.counter; //Returns the value
    }

}
