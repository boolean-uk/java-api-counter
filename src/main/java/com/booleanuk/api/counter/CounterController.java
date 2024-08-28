package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("counter")
public class CounterController {
    private int counter;
    private HashMap<String, Integer> nameInc;

    public CounterController() {
        counter = 0;
        nameInc = new HashMap<>();
    }

    @GetMapping
    public String getCounting() {
        return String.valueOf(counter);
    }

    @GetMapping("increment")
    public String increment() {
        return String.valueOf(++counter);
    }

    @GetMapping("decrement")
    public String decrement() {
        return String.valueOf(--counter);
    }

    @GetMapping("custom/{name}")
    public String getName(@PathVariable String name) {
        int temp = nameInc.getOrDefault(name, 0);
        return String.valueOf(temp);
    }

    @GetMapping("custom/{name}/increment")
    public String getNameInc(@PathVariable String name) {
        if (nameInc.containsKey(name)) {
            nameInc.replace(name, nameInc.get(name) + 1);
            return String.valueOf(nameInc.get(name));
        }
        else {
            nameInc.put(name, 1);
            return String.valueOf(1);
        }
    }

    @GetMapping("custom/{name}/decrement")
    public String getNameDec(@PathVariable String name) {
        if (nameInc.containsKey(name)) {
            nameInc.replace(name, nameInc.get(name) - 1);
            return String.valueOf(nameInc.get(name));
        }
        else {
            nameInc.put(name, -1);
            return String.valueOf(-1);
        }
    }
}
