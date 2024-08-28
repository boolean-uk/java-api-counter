package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("counter")
public class CounterController {
	public int counter;
	public HashMap<String, Integer> nameToCounter;


	public CounterController(){
		counter = 0;
		nameToCounter = new HashMap<>();
	}

	@GetMapping()
	public String getCounter(){
		return withDivAndLink(Integer.toString(counter));
	}

	@GetMapping("increment")
	public String increment(){
		return withDivAndLink(Integer.toString(++counter));
	}

	@GetMapping("decrement")
	public String decrement(){
		return withDivAndLink(Integer.toString(--counter));
	}

	public String withDivAndLink(String s){
		return "<div>" + s + "</div>"
			+"<div><a href=\"http://localhost:4000/counter/increment\">Increment Counter</a></div>"
			+ "<div><a href=\"http://localhost:4000/counter/decrement\">Decrement Counter</a></div>";
	}

	public String withDivAndLinkWithCustom(String num, String name){
		return "<div>" + num + "</div>"
				+ "<div><a href=\"http://localhost:4000/counter/custom/" + name + "/increment\">Increment Counter</a></div>"
				+ "<div><a href=\"http://localhost:4000/counter/custom/" + name + "/decrement\">Decrement Counter</a></div>";

	}

	@GetMapping("custom/{name}")
	public String getCustom(@PathVariable String name){
		String num = "";

		if (nameToCounter.containsKey(name)){
			int c = nameToCounter.get(name);
			num = Integer.toString(c);
		}
		else {
			nameToCounter.put(name, 0);
			num = "0";
		}

		return withDivAndLinkWithCustom(num,	 name);
	}

	@GetMapping("custom/{name}/increment")
	public String incrementName(@PathVariable String name){
		if (nameToCounter.containsKey(name)){
			int c = nameToCounter.get(name);
			nameToCounter.merge(name, 1, (a, b) -> a + b);
//			return Integer.toString(c+1);
			return withDivAndLinkWithCustom(String.valueOf(c+1),	 name);

		}

		nameToCounter.put(name, 1);
		return withDivAndLinkWithCustom(String.valueOf(1),	 name);
	}


	@GetMapping("custom/{name}/decrement")
	public String decrementName(@PathVariable String name){
		if (nameToCounter.containsKey(name)){
			int c = nameToCounter.get(name);
			nameToCounter.put(name, c-1);
			return withDivAndLinkWithCustom(String.valueOf(c-1),	 name);
		}

		nameToCounter.put(name, -1);
		return withDivAndLinkWithCustom(String.valueOf(-1),	 name);
	}
	/* Sample html code with current counter value 8 and name = nmk
	<body>
	<div>8</div>
	<div><a href="http://localhost:4000/counter/custom/nmk/increment">Increment Counter</a></div>
	<div><a href="http://localhost:4000/counter/custom/nmk/decrement">Decrement Counter</a></div>
	</body>
	 */
}
