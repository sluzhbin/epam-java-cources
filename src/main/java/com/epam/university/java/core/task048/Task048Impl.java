package com.epam.university.java.core.task048;

import java.util.Collection;
import java.util.LinkedHashSet;

public class Task048Impl implements Task048 {

    @Override
    public Collection<Integer> getArmstrongNumbers(Integer from, Integer to) {

        if (from == null || to == null || from < 0 || to < 0) {
            throw new IllegalArgumentException();
        }
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 1; i <= 99999; i++) {
            char[] chars = String.valueOf(i).toCharArray();
            int buf = 0;
            for (int j = 0; j < chars.length; j++) {
                buf += Math.pow(chars[j] - '0', chars.length);
            }
            if (buf == i) {
                set.add(i);
            }
        }
        return set;
    }
}
