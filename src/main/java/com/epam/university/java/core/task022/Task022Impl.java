package com.epam.university.java.core.task022;

import java.util.*;

public class Task022Impl implements Task022 {

    @Override
    public int maxSum(Collection<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
        ArrayList<Integer> integers = new ArrayList<>(numbers);
        Collections.sort(integers);
        int sum = 0;
        for (int i = 1; i < integers.size(); i++) {
            sum += integers.get(i);
        }
        return sum;
    }

    @Override
    public int minSum(Collection<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
        ArrayList<Integer> integers = new ArrayList<>(numbers);
        Collections.sort(integers);
        int sum = 0;
        for (int i = 0; i < integers.size() - 1; i++) {
            sum += integers.get(i);
        }
        return sum;
    }
}
