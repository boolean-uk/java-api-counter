package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/counter")
public class CounterController {

    private int value = 0;

    private List<Counter> counterList;

    public CounterController() {
        this.counterList = new ArrayList<>();
        this.counterList.add(new Counter("default", 0));
    }

    @GetMapping("/value")
    public Integer getCurrentValue() {
        return this.value;
    }

    @GetMapping("/increment")
    public Integer increment() {
        value += 1;
        return value;
    }

    @GetMapping("/decrement")
    public Integer decrement() {
        value -= 1;
        return value;
    }

    @GetMapping("/custom/{name}")
    public Integer createOrFindCounter(@PathVariable String name) {
        for (Counter c : counterList) {
            if (c.getName().equals(name)) {
                return c.getValue();
            }
        }
        counterList.add(new Counter(name, 0));
        return 0;
    }

    @GetMapping("/custom/{name}/increment")
    public Integer incrementCustomCounter(@PathVariable String name) {
        for (Counter c : counterList) {
            if (c.getName().equals(name)) {
                c.setValue(c.getValue() + 1);
                return c.getValue();
            }
        }
        counterList.add(new Counter(name, 1));
        return 1;
    }

    @GetMapping("/custom/{name}/decrement")
    public Integer decrementCustomCounter(@PathVariable String name) {
        for (Counter c : counterList) {
            if (c.getName().equals(name)) {
                c.setValue(c.getValue() - 1);
                return c.getValue();
            }
        }
        counterList.add(new Counter(name, -1));
        return -1;
    }

    // Getter for list
    public List<Counter> getCounterList() {
        return counterList;
    }
}
