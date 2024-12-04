package com.booleanuk.api.counter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomCounterControllerTest {
  @Test
  public void testCustom() {
    CustomCounterController controller = new CustomCounterController();

    Assertions.assertEquals(0, controller.get("Dave"));
    Assertions.assertEquals(0, controller.get("Herman"));
  }

  @Test
  public void testIncrementCustom() {
    CustomCounterController controller = new CustomCounterController();

    Assertions.assertEquals(1, controller.increment("Dave"));
    Assertions.assertEquals(2, controller.increment("Dave"));

    Assertions.assertEquals(1, controller.increment("Herman"));
    Assertions.assertEquals(2, controller.increment("Herman"));
  }

  @Test
  public void testDecrementCustom() {
    CustomCounterController controller = new CustomCounterController();

    Assertions.assertEquals(-1, controller.decrement("Dave"));
    Assertions.assertEquals(-2, controller.decrement("Dave"));

    Assertions.assertEquals(-1, controller.decrement("Herman"));
    Assertions.assertEquals(-2, controller.decrement("Herman"));
  }
}
