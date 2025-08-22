package com.booleanuk.api.counter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class counterTest {

    @Test
    void testIncrementNewName() {
        CounterController controller = new CounterController();
        String result = controller.increment("Bob");
        Assertions.assertEquals("hello Bob this is you new value: 1", result);
    }
}
