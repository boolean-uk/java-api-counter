package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("counter")
public class CounterController {
    private int counter;

    public CounterController() {
        this.counter = 0;
    }

}
