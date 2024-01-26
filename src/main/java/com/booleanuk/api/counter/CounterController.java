package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter")
public class CounterController {
	private int number = 0;
	@GetMapping("/current")
	public int current() {
		return this.number;
	}
@GetMapping("/increment")
	public int increment() {
		return ++this.number;
	}
	@GetMapping("/decrement")
	public int decrement() {
		return --this.number;
	}

}
