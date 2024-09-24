package org.apache.maven.samples.reactor.modc2;

import org.apache.maven.samples.reactor.moda.Calc;
import org.apache.maven.samples.reactor.modb.CalcImpl;

public class CalcUI {
    public static void main(final String... args) {
        Calc calc = new CalcImpl();
        System.out.println(calc.add(3, 9));
    }
}
