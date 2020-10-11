package com.epam.university.java.core.task028;

public class Task028Impl implements Task028 {

    @Override
    public int getWays(int value, int power) {
        if (value == 0 || power == 0) {
            throw new IllegalArgumentException();
        }
        return countWays(value, power, 1);
    }

    private int countWays(int value, int power, int start) {
        int delta = (int) (value - Math.pow(start, power));
        if (delta == 0) {
            return 1;
        }
        if (delta < 0) {
            return 0;
        }
        return countWays(value, power, start + 1) + countWays(delta, power, start + 1);
    }
}
