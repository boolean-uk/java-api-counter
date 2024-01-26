package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter")
public class CounterController {
    private int count = 0;

    @GetMapping
    public int getCount(){
        return this.count;
    }
    @GetMapping("/increment")
    public int getIncrement(){
        return this.count++;
    }
    @GetMapping("/decrement")
    public int getDecrement(){
        return this.count--;
    }


}
