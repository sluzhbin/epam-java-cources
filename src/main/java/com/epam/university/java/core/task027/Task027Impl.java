package com.epam.university.java.core.task027;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task027Impl implements Task027 {

    @Override
    public Collection<Integer> extract(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 1; i <= sourceString.length() / 2; i++) {
            List<Integer> result = new ArrayList<>();
            String sequence = sourceString.substring(0, i);
            int first = Integer.parseInt(sequence);
            if (first == 0) {
                break;
            }
            result.add(first);
            int counter = 1;
            while (sequence.length() < sourceString.length()) {
                sequence = sequence.concat(String.valueOf(first + counter));
                result.add(first + counter);
                counter++;
            }
            if (sourceString.equals(sequence)) {
                return result;

            }
        }
        return new ArrayList<Integer>();
    }
}
