package org.apache.maven.samples.reactor.modb;

import org.apache.maven.samples.reactor.moda.Calc;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalcImplTest {
    private final Calc calc = new CalcImpl();

    @Test
    void test_add() {
        assertThat(calc.add(1, 7)).isEqualTo(8);
    }    
}
