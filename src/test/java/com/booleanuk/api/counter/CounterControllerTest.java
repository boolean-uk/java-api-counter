package com.booleanuk.api.counter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountControllerTest{

	private CounterController c;
	
	public CountControllerTest(){
		this.c = new CounterController();
	}

	@Test
	void shouldGetCount(){
		int res = this.c.getCount();
		Assertions.assertEquals(0,res);
	}

	@Test
	void shouldGetIncrease(){
		int res = this.c.getIncrease();
		Assertions.assertEquals(1, res);
	}

	@Test
	void shouldGetDecrease(){
		int res = this.c.getDecrease();
		Assertions.assertEquals(-1, res);
	}

	@Test
	void shouldGetCustomCount(){
		int res = this.c.getCustomCount("nvim rocks");
		Assertions.assertEquals(0, res);
	}

	@Test
	void shouldGetCustomIncrease(){
		int res = this.c.getCustomIncrease("nvim rocks");
		Assertions.assertEquals(1, res);
	}

	@Test
	void shouldGetCustomDecrease(){
		int res = this.c.getCustomDecrease("nvim rocks");
		Assertions.assertEquals(-1, res);
	}

}
