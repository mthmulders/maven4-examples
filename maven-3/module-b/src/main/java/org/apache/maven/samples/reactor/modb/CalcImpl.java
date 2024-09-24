package org.apache.maven.samples.reactor.modb;

import org.apache.maven.samples.reactor.moda.Calc;

public class CalcImpl implements Calc {
    public int add(int a, int b) {
        return a + b;
    }
}