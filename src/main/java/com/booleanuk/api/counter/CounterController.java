package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/counter")
public class CounterController {
	private Map<String, Integer> counters = new HashMap<>();

	@GetMapping("/current")
	public int current() {
		return this.counters.getOrDefault("default", 0);
	}

	@GetMapping("/increment")
	public int increment() {
		return incrementCounter("default");
	}

	@GetMapping("/decrement")
	public int decrement() {
		return decrementCounter("default");
	}
	@GetMapping("/custom/{name}")
	public int customCounter(@PathVariable String name) {
		return this.counters.getOrDefault(name, 0);
	}

	@GetMapping("/custom/{name}/increment")
	public int incrementCustomCounter(@PathVariable String name) {
		return incrementCounter(name);
	}

	@GetMapping("/custom/{name}/decrement")
	public int decrementCustomCounter(@PathVariable String name) {
		return decrementCounter(name);
	}
	private int incrementCounter(String name) {
		int value = this.counters.getOrDefault(name, 0) + 1;
		this.counters.put(name, value);
		return value;
	}

	private int decrementCounter(String name) {
		int value = this.counters.getOrDefault(name, 0) - 1;
		this.counters.put(name, value);
		return value;
	}
}
