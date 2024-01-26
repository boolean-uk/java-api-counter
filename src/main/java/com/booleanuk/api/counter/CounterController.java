package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("counter")
public class CounterController {
    private int counter;
    HashMap<String,Integer> countMap;
    public CounterController(){
        this.counter = 0;
        this.countMap = new HashMap<>();
    }

    @GetMapping
    public String getCounter() {
        return Integer.toString(this.counter);
    }
    @GetMapping("/increment")
    public String increment(){
        this.counter++;
        return Integer.toString(this.counter);
    }
    @GetMapping("/decrement")
    public String decrement(){
        this.counter--;
        return Integer.toString(this.counter);
    }

    @GetMapping("/custom/{nameCheck}")
    public String getNameCounter(@PathVariable (name = "nameCheck") String nameCheck){
        if(countMap.containsKey(nameCheck)){
            this.counter = countMap.get(nameCheck);
            countMap.put(nameCheck,counter);
        }else{
            countMap.put(nameCheck,0);
            return "Added "+nameCheck+" to the be counted!";
        }
        String count = Integer.toString(countMap.get(nameCheck));
        return nameCheck+" has a count of "+count;
    }

    @GetMapping("/custom/{nameCheck}/increment")
    public String incrementName(@PathVariable (name = "nameCheck") String nameCheck){
        if(countMap.containsKey(nameCheck)){
            countMap.put(nameCheck,countMap.get(nameCheck)+1);
        }else{
            countMap.put(nameCheck,1);
        }
        return nameCheck+" has a count of "+countMap.get(nameCheck);
    }
    @GetMapping("/custom/{nameCheck}/decrement")
    public String decrementName(@PathVariable (name = "nameCheck") String nameCheck){
        if(countMap.containsKey(nameCheck)){
            countMap.put(nameCheck,countMap.get(nameCheck)-1);
        }else{
            countMap.put(nameCheck,-1);
        }
        return nameCheck+" has a count of "+countMap.get(nameCheck);
    }
}
