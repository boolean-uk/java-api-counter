package com.booleanuk.api.counter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Data
@Slf4j
@RestController
@RequestMapping("counter")
public class CounterController {
    private static int INITIAL_AMOUNT = 0;
    private static int AMOUNT = 1;
    HashMap<String, Integer> individualCounters;
    private int number;

    public CounterController() {
        this.individualCounters = new HashMap<>();
        this.number = INITIAL_AMOUNT;
    }

    @GetMapping
    public int getNumber() {
        return number;
    }

    @GetMapping("increment")
    public int incrementNumber() {
        number += AMOUNT;
        log.info("Increasing number by " + AMOUNT + ". New number: " + number);
        return number;
    }

    @GetMapping("decrement")
    public int decrementNumber() {
        number -= AMOUNT;
        log.info("Decreasing number by " + AMOUNT + ". New number: " + number);
        return number;
    }

    @GetMapping("custom/{name}")
    public int getIndividualCounter(@PathVariable String name) {
        Integer currentValue = individualCounters.putIfAbsent(name, INITIAL_AMOUNT);
        if (currentValue == null) {
            log.info("Counter created for " + name + ".");
            currentValue = individualCounters.get(name);
        }
        return currentValue;
    }

    @GetMapping("custom/{name}/increment")
    public int incrementIndividualCounter(@PathVariable String name) {
        getIndividualCounter(name);
        individualCounters.put(name, individualCounters.get(name) + AMOUNT);
        int increasedNumber = individualCounters.get(name);
        log.info("Increasing " + name + " counter by " + AMOUNT + ". New number: " + increasedNumber);
        return increasedNumber;
    }

    @GetMapping("custom/{name}/decrement")
    public int decrementIndividualCounter(@PathVariable String name) {
        getIndividualCounter(name);
        individualCounters.put(name, individualCounters.get(name) - AMOUNT);
        int decreasedNumber = individualCounters.get(name);
        log.info("Decreasing " + name + " counter by " + AMOUNT + ". New number: " + decreasedNumber);
        return decreasedNumber;
    }
}
