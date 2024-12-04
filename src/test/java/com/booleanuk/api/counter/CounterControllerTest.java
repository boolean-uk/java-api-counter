package com.booleanuk.api.counter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CounterControllerTest {
  @Test
  public void testCounter() {
    CounterController controller = new CounterController();

    Assertions.assertEquals(0, controller.get());
  }

  @Test
  public void testIncrement() {
    CounterController controller = new CounterController();

    Assertions.assertEquals(1, controller.increment());
    Assertions.assertEquals(2, controller.increment());
    Assertions.assertEquals(3, controller.increment());
  }

  @Test
  public void testDecrement() {
    CounterController controller = new CounterController();

    Assertions.assertEquals(-1, controller.decrement());
    Assertions.assertEquals(-2, controller.decrement());
    Assertions.assertEquals(-3, controller.decrement());
  }
}
