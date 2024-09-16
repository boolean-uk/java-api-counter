package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/counter")
public class CounterController {
   int value = 0;
   HashMap<String,Integer> users;

   public CounterController() {
       users = new HashMap<String,Integer>();
   }
   @GetMapping
   public int getValue(){
       return this.value;
   }

   @GetMapping("/increment")
   public int increment() {
       this.value++;
       return this.value;
   }

   @GetMapping("/decrement")
    public int decrement() {
       this.value--;
       return this.value;
   }

   @GetMapping("/custom/{name}")
    public int getCustomValue(@PathVariable String name){
       if (this.users.containsKey(name)){
           this.users.put(name,this.users.get(name));
       }else {
           this.users.put(name,0);
       }
       return this.users.get(name);
   }

   @GetMapping("/custom/{name}/increment")
    public int incrementUser(@PathVariable String name){
       if (this.users.containsKey(name)) {
           this.users.put(name, this.users.get(name) + 1);
       } else {
           this.users.put(name,0);
       }
       return this.users.get(name);
   }

    @GetMapping("/custom/{name}/decrement")
    public int decrementUser(@PathVariable String name){
        if (this.users.containsKey(name)) {
            this.users.put(name, this.users.get(name) - 1);
        } else {
            this.users.put(name,0);
        }
        return this.users.get(name);
    }


}
