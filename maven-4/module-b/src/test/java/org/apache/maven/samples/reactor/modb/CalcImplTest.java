package org.apache.maven.samples.reactor.modb;

import org.apache.maven.samples.reactor.moda.Calc;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalcImplTest {
    private final Calc calc = new CalcImpl();

    @Test
    void test_add() {
        assertEquals(8, calc.add(1, 7));
    }    
}
