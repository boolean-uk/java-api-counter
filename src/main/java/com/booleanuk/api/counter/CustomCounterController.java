package com.booleanuk.api.counter;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomCounterController {
  private final Map<String, Integer> counters = new HashMap<>();

  @GetMapping(value = "/counter/custom/{name}")
  public int get(@PathVariable String name) {
    return this.counters.getOrDefault(name, 0);
  }

  @GetMapping(value = "/counter/custom/{name}/increment")
  public int increment(@PathVariable String name) {
    return this.counters.merge(name, 1, Integer::sum);
  }

  @GetMapping(value = "/counter/custom/{name}/decrement")
  public int decrement(@PathVariable String name) {
    return this.counters.merge(name, -1, Integer::sum);
  }
}
