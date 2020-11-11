package com.epam.university.java.core.task036;

import java.util.function.Function;

public class IntegratorImpl implements Integrator {

    private static final double delta = 0.0001;

    @Override
    public double integrate(double left, double right, Function<Double, Double> function) {
        double area = 0;
        double modifier = 1;
        if (left > right) {
            double tempA = left;
            left = right;
            right = tempA;
            modifier = -1;
        }
        for (double i = left + delta; i < right; i += delta) {
            double dFromA = i - left;
            area += (delta / 2)
                    *
                    (function.apply(left + dFromA)
                            +
                            function.apply(left + dFromA - delta));
        }
        return (Math.round(area * 10000.0) / 10000.0) * modifier;
    }
}

