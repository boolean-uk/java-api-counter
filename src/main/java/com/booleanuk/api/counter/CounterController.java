package com.booleanuk.api.counter;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/counter")
public class CounterController {

    private int count ;
    public CounterController(){
        this.count=0;

    }



    @GetMapping
    public int getCount() {
        return count;
    }

    @GetMapping("/increment")
    public int incrementCount() {
        count++;
        return count;
    }

    @GetMapping("/decrement")
    public int decrementCount() {
        count--;
        return count;
    }
}

