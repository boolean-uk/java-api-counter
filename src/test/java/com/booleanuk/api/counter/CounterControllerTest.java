package com.booleanuk.api.counter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CounterControllerTest {

    @Test
    public void getCounter() {
        CounterController cC = new CounterController();

        Assertions.assertEquals(0, cC.getCounter());
    }

    @Test
    public void increaseCounter() {
        CounterController cC = new CounterController();

        cC.incrementCounter();

        Assertions.assertEquals(1, cC.getCounter());
    }

    @Test
    public void decreaseCounter() {
        CounterController cC = new CounterController();

        cC.decrementCounter();

        Assertions.assertEquals(-1, cC.getCounter());
    }

    @Test
    public void makeCustomCounterTest() {
        CounterController cC = new CounterController();
        String id = "Custom";
        cC.getCustomCounter(id);

        Assertions.assertEquals(0, cC.customCounter.get(id));

        cC.incrementCustomCounter(id);

        Assertions.assertEquals(1, cC.customCounter.get(id));

        cC.decrementCustomCounter(id);
        Assertions.assertEquals(0, cC.customCounter.get(id));
    }

    @Test
    public void makeNegativeCustomCounterTest() {
        CounterController cC = new CounterController();

        String id = "negative";

        cC.decrementCustomCounter(id);

        Assertions.assertEquals(-1, cC.customCounter.get(id));
    }

    @Test
    public void makePositiveCustomCounterTest() {
        CounterController cC = new CounterController();

        String id = "positive";

        cC.incrementCustomCounter(id);

        Assertions.assertEquals(1, cC.customCounter.get(id));
    }
}
