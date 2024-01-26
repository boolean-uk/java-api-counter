package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("counter")
public class CounterController {
    private int currentNumber = 0;

    private final HashMap<String, Integer> customNumbers = new HashMap<>();

    @GetMapping("")
    public String display() {
        return currentNumber + "";
    }

    @GetMapping("increment")
    public String increment() {
        currentNumber++;
        return currentNumber + "";
    }

    @GetMapping("decrement")
    public String decrement() {
        currentNumber--;
        return currentNumber + "";
    }

    @GetMapping("custom/{key}")
    public String custom(@PathVariable String key) {
        return customNumbers.containsKey(key) ? key + "'s current number is: " + customNumbers.get(key) : "Cannot display for an invalid entry!";
    }

    @GetMapping("custom/{key}/{command}")
    public String custom(@PathVariable String key, @PathVariable String command) {
        if (!command.equals("increment") && !command.equals("decrement")) return command + " is not a valid command!";
        if (customNumbers.containsKey(key)) customNumbers.put(key, customNumbers.get(key) + (command.equals("increment") ? 1 : -1));
        else customNumbers.put(key, command.equals("increment") ? 1 : -1);

        return key + "'s current number is: " + customNumbers.get(key);
    }
}
