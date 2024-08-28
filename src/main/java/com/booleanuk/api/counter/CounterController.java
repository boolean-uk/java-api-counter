package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter")
public class CounterController {
    private Counter counter;

    public CounterController(Counter counter) {
        this.counter = counter;
    }

    @GetMapping
    public String showCounter() {
        if (counter != null) {
            return "Initial value of the counter: " + counter.getNumber();
        }
        else {
            return "Counter not created yet";
        }
    }

    @GetMapping("/increment")
    public String incrementCounter() {
        this.counter.increment();
        return "Incremented counter, new value is: " + this.counter.getNumber();
    }

    @GetMapping("/decrement")
    public String decrementCounter() {
        this.counter.decrement();
        return "Decremented counter, new values is: " + this.counter.getNumber();
    }

    @GetMapping("/custom/{name}")
    public String createCustomCounter(@PathVariable String name) {
        if (!this.counter.getName().equals(name)) {
            this.counter = new Counter(name, 0);
            return "New counter created for: " + name + "!";
        }
        return "Counter for " + name + " already exists. Counter value is: " + this.counter.getNumber();
    }

    @GetMapping("/custom/{name}/increment")
    public String incrementNamedCounter(@PathVariable String name) {
        if (this.counter.getName().equals(name)) {
            this.counter.increment();
            return "Counter exists for " + name + ", new value is: " + this.counter.getNumber();
        }

        this.counter = new Counter(name, 1);
        return "New counter created for " + name + ", initialized value is " + this.counter.getNumber();


    }

    @GetMapping("/custom/{name}/decrement")
    public String decrementNamedCounter(@PathVariable String name) {
        if (this.counter.getName().equals(name)) {
            this.counter.decrement();
            return "Counter exists for " + name + ", counter value is " + this.counter.getNumber();
        }
        this.counter = new Counter(name, -1);
        return "New counter created for " + name + ", initialized value is " + this.counter.getNumber();

    }
}
