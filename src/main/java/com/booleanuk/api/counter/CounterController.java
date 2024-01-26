package com.booleanuk.api.counter;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping("/counter")
public class CounterController {

    private ArrayList<Counter> listOfCounters;

    private int counterValue;

    public CounterController() {
        listOfCounters = new ArrayList<>();
        counterValue = 0;
    }



    @GetMapping
    public String getCounterValue() {
        return "Value of counter: " + this.counterValue;
    }


    @GetMapping("/increment")
    public String incrementCounter() {
        this.counterValue += 1;
        return "Value of counter: " + this.counterValue;
    }


    @GetMapping("/decrement")
    public String decrementCounter() {
        this.counterValue -= 1;
        return "Value of counter: " + this.counterValue;
    }

    @GetMapping("/custom/{name}")
    public String customCounter(@PathVariable String name) {
        for(Counter counter : listOfCounters) {
            if(counter.getName().equalsIgnoreCase(name)) {
                return "Value of counter: " + counter.getCounterValue();
            }
        }
        Counter counter = new Counter(name);
        listOfCounters.add(counter);
        return "Value of counter: " + counter.getCounterValue();
    }

    @GetMapping("/custom/{name}/increment")
    public String incrementCustomerCounter(@PathVariable String name) {
        for(Counter counter : listOfCounters) {
            if(counter.getName().equalsIgnoreCase(name)) {
                counter.setCounterValue(counter.getCounterValue() + 1);
                return "Value of counter: " + counter.getCounterValue();
            }
        }
        Counter counter = new Counter(name);
        counter.setCounterValue(1);
        listOfCounters.add(counter);
        return "Value of counter: " + counter.getCounterValue();
    }

    @GetMapping("/custom/{name}/decrement")
    public String decrementCustomerCounter(@PathVariable String name) {
        for(Counter counter : listOfCounters) {
            if(counter.getName().equalsIgnoreCase(name)) {
                counter.setCounterValue(counter.getCounterValue() - 1);
                return "Value of counter: " + counter.getCounterValue();
            }
        }
        Counter counter = new Counter(name);
        counter.setCounterValue(-1);
        listOfCounters.add(counter);
        return "Value of counter: " + counter.getCounterValue();
    }


}
