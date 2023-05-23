package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Objects;

@RestController
@RequestMapping("/counter")
public class CounterController {
    private int counter;
    private ArrayList<UserCounter> users;

    public CounterController() {
        this.counter = 0;
        this.users = new ArrayList<>();
    }

    @GetMapping
    public int getCounter() {
        return counter;
    }

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
    //Extentions!

    private UserCounter isUserin(String name) {
        for (UserCounter user : users) {
            if (Objects.equals(user.getName(), name)) {
                return user;
            }
        }
        UserCounter userCounter = new UserCounter(name);
        users.add(userCounter);
        return userCounter;
    }

    @GetMapping("/custom/{name}")
    public int getNamedCounter(@PathVariable String name) {
        UserCounter userCounter = isUserin(name);
        return userCounter.getCounter();
    }

    @GetMapping("/custom/{name}/increment")
    public int increamentUserCounter(@PathVariable String name) {
        UserCounter userCounter = isUserin(name);
        userCounter.plusCounter();
        return userCounter.getCounter();
    }
    @GetMapping("/custom/{name}/decrement")
    public int decrementUserCounter(@PathVariable String name){
        UserCounter userCounter = isUserin(name);
        userCounter.minusCounter();
        return userCounter.getCounter();


    }

}
