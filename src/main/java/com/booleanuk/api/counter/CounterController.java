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
    private Map<String, Integer> indexVal = new HashMap<>();


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


    @GetMapping("/custom/{index}")
    public int customIndex(@PathVariable(name = "index") String index) {
        if (indexVal.containsKey(index)) {
//            int newValue = indexVal.get(index);
//            newValue++;
//            indexVal.put(index, newValue);
//            int returnValue = indexVal.get(index);

            int returnValueExists = indexVal.get(index);
            return returnValueExists;
        } else {
            indexVal.put(index, 0);

            return indexVal.get(index);
        }
    }

    @GetMapping("/custom/{index}/increment")
    public int customIndexIncrement(@PathVariable(name = "index") String index) {
        if (indexVal.containsKey(index)) {
            int newValue = indexVal.get(index);
            newValue++;
            indexVal.put(index, newValue);
            int returnValue = indexVal.get(index);
            return returnValue;
        } else {
            indexVal.put(index, 1);
            return indexVal.get(index);
        }
    }

    @GetMapping("/custom/{index}/decrement")
    public int customIndexDecrement(@PathVariable(name = "index") String index) {
        if (indexVal.containsKey(index)) {
            int newValue = indexVal.get(index);
            newValue--;
            indexVal.put(index, newValue);
            int returnValue = indexVal.get(index);
            return returnValue;
        } else {
            indexVal.put(index, -1);
            return indexVal.get(index);
        }
    }
}
