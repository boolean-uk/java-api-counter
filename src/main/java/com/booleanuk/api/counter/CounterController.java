package com.booleanuk.api.counter;


//
//1. Annotate the `CounterController` class appropriately to set it up as a REST controller, and map all requests of `http://localhost:4000/counter` to it
//        2. Create a GET method that responds with the current value of the counter. Its initial value should always be 0
//        3. Create a GET method that maps to the route `http://localhost:4000/counter/increment` that increases the counter by 1 and responds with the updated value. The method you created in step 2 should also now respond with the updated value
//        4. Create a GET method that maps to the route `http://localhost:4000/counter/decrement` that decreases the counter by 1 and responds with the updated value

//        1. Create a GET method that maps to the route `http://localhost:4000/counter/custom/{name}`
//        - `{name}` is a path variable, the client can provide any string they want
//        - If a counter with the provided name does not already exist, a new counter should be created with the name provided in the path variable, initialised to a value of 0
//        - If a counter with the provided name does exist, the route should respond with the current value of the named counter
//        2. Create a GET method that maps to the route `http://localhost:4000/counter/custom/{name}/increment`
//        - If a counter with the provided name exists, increase the value of that counter by 1 and then respond with the new value
//        - If a counter with the provided name does not exist, it should be created and initialised with a value of 1
//        - The route you created in step 1 should respond appropriately
//        3. Create a GET method that maps to the route `http://localhost:4000/counter/custom/{name}/decrement`
//        - If a counter with the provided name exists, decrease the value of that counter by 1 and then respond with the new value
//        - If a counter with the provided name does not exist, it should be created and initialised with a value of -1
//        - The previous routes you created should respond appropriately

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


@RestController
@RequestMapping("counter")
public class CounterController {
    private ArrayList<String> jokes;
    Random randomizer = new Random();
    private int counter;
    private HashMap<String, Integer> names;

    public CounterController() {
        this.counter = 0;
        this.names = new HashMap<>();

    }





    @GetMapping("increment")
    public int increment() {
       counter++;

        return counter;
    }

    @GetMapping("decrement")
    public int decrement() {
        counter--;

        return counter;
    }

    public int getCounter() {

        return this.counter;
    }

    @GetMapping("custom/{name}")
    public int nameCount(@PathVariable String name) {

        if(this.names.containsKey(name)){
            this.names.put(name, this.names.get(name));
        } else {
            names.put(name, 0);
        }
        return names.get(name);

    }


    @GetMapping("custom/{name}/increment")
    public int nameIncrement(@PathVariable String name) {


        if(this.names.containsKey(name)){
            this.names.put(name, this.names.get(name)+1);
        } else {
            names.put(name, 0);
        }
        return names.get(name);
    }


    @GetMapping("custom/{name}/decrement")
    public int nameDecrement(@PathVariable String name) {

        if(this.names.containsKey(name)){
            this.names.put(name, this.names.get(name)-1);
        } else {
            names.put(name, 0);
        }
        return names.get(name);
    }


}





