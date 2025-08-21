package com.booleanuk.api.counter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCounterController {

    @Test
    void shouldReturnInitialValueZero() {
        CounterController controller = new CounterController();
        assertEquals(0, controller.getCurrentValue());
    }

    @Test
    void shouldIncrementValue() {
        CounterController controller = new CounterController();
        assertEquals(1, controller.increment());
    }

    @Test
    void shouldDecrementValue() {
        CounterController controller = new CounterController();
        assertEquals(-1, controller.decrement());
    }

    // Extension
    @Test
    void shouldCreateNewCounterWithZero() {
        CounterController controller = new CounterController();
        assertEquals(0, controller.createOrFindCounter("counter1"));
    }

    @Test
    void defaultCounterShouldReturnZero() {
        CounterController controller = new CounterController();
        assertEquals(0, controller.createOrFindCounter("default"));
        assertEquals(1, controller.getCounterList().size());
    }

    @Test
    void shouldReturnExistingCounterValue() {
        CounterController controller = new CounterController();
        controller.createOrFindCounter("");
        controller.incrementCustomCounter("counter1");
        assertEquals(1, controller.createOrFindCounter("counter1"));
    }

    @Test
    void shouldIncrementExistingCounter() {
        CounterController controller = new CounterController();
        controller.createOrFindCounter("counter1");
        assertEquals(1, controller.incrementCustomCounter("counter1"));
        assertEquals(1, controller.createOrFindCounter("counter1"));
    }

    @Test
    void shouldCreateAndIncrementNewCounter() {
        CounterController controller = new CounterController();
        assertEquals(1, controller.incrementCustomCounter("counter1"));
        assertEquals(1, controller.createOrFindCounter("counter1"));
    }

    @Test
    void shouldDecrementExistingCounter() {
        CounterController controller = new CounterController();
        controller.createOrFindCounter("counter1");
        assertEquals(-1, controller.decrementCustomCounter("counter1"));
        assertEquals(-1, controller.createOrFindCounter("counter1"));
    }

    @Test
    void shouldCreateAndDecrementNewCounter() {
        CounterController controller = new CounterController();
        assertEquals(-1, controller.decrementCustomCounter("counter1"));
        assertEquals(-1, controller.createOrFindCounter("counter1"));
    }
}
