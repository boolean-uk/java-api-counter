package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("counter")
public class CounterController {

    private HashMap<String, Integer> elementCounter;

    public CounterController() {
        this.elementCounter = new HashMap<>();
    }

    @GetMapping("{name}")
    public String counter(@PathVariable String name) {
        if(!elementCounter.containsKey(name)) {
            elementCounter.put(name, 0);
        }
        return elementCounter.get(name).toString();
    }

    @GetMapping("custom/{name}/increment")
    public String increment(@PathVariable String name) {
        if(!elementCounter.containsKey(name)) {
            elementCounter.put(name, 0);
        }
        elementCounter.put(name, elementCounter.get(name)+1);
        return elementCounter.get(name).toString();
    }

    @GetMapping("custom/{name}/decrement")
    public String decrement(@PathVariable String name) {
        if(!elementCounter.containsKey(name)) {
            elementCounter.put(name, 0);
        }
        elementCounter.put(name, elementCounter.get(name)-1);
        return elementCounter.get(name).toString();
    }

}
