package com.booleanuk.api.counter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@Slf4j
@RestController
@RequestMapping("counter")
public class CounterController {
    private static int AMOUNT = 1;
    private int number;

    public CounterController() {
        this.number = 0;
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
}
