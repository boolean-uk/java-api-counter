package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/counter/custom")
public class CustomCounterController {

    private Map<String, Integer> counters;

    public CustomCounterController(){
        counters = new HashMap<>();
    }

    @GetMapping("/{name}")
    public int getOrCreateCounter(@PathVariable(name = "name") String name){
        counters.putIfAbsent(name, 0);
        return counters.get(name);
    }

    @GetMapping("/{name}/increment")
    public int incrementCounter(@PathVariable(name = "name") String name){
        counters.putIfAbsent(name, 0);

        Integer val = counters.get(name);
        counters.replace(name, ++val);
        return val;

    }
}
