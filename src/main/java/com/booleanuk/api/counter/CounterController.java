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
    public int counter = 0;


    @GetMapping("/increment")
    public int increment() {
        counter += 1;
        return counter;
    }

    @GetMapping("/decrement")
    public int decrement() {
        counter -= 1;
        return counter;
    }




}
