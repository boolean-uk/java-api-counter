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
    private Map<String, Integer> indexValue = new HashMap<>();

    @GetMapping("/increment")
    public int increment()
    {
        counter += 1;
        return counter;
    }

    @GetMapping("/decrement")
    public int decrement()
    {
        counter -= 1;
        return counter;
    }

    @GetMapping("/custom/{index}")
    public int customIndex(@PathVariable(name = "index") String index) {
        return indexValue.computeIfAbsent(index, key -> 0);
    }


    @GetMapping("/custom/{index}/increment")
    public int customIndexIncrement(@PathVariable(name = "index") String index)
    {
        int newValue = indexValue.getOrDefault(index, 0) + 1;
        indexValue.put(index, newValue);
        return newValue;
    }

    @GetMapping("/custom/{index}/decrement")
    public int customIndexDecrement(@PathVariable(name = "index") String index)
    {
        int newValue = indexValue.getOrDefault(index, 0) - 1;
        indexValue.put(index, newValue);
        return newValue;
    }

}
