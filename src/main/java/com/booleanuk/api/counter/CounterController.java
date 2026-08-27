package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter")
public class CounterController {

    private int coreCount;

    public CounterController(){
        this.coreCount = 0;
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

}
