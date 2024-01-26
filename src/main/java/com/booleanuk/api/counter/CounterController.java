package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("counter")
public class CounterController {
    private int counterValue;

    public CounterController()
    {
        this.counterValue = 0;
    }

    @GetMapping
    public int getCount()
    {
        return this.counterValue;
    }

    @GetMapping("increment")
    public int incrementValue()
    {
        this.counterValue += 1;
        return this.counterValue;
    }

    @GetMapping("decrement")
    public int decrementValue()
    {
        this.counterValue -= 1;
        return this.counterValue;
    }
}
