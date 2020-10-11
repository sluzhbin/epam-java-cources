package com.epam.university.java.core.task024;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Task024Impl implements Task024 {

    @Override
    public Collection<String> getWordsCount(String source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        if (source.isEmpty()) {
            return Collections.emptyList();
        }
        String[] result = source.split("(?=[A-ZА-ЯÄÖÜ])");
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            list.add((result[i]).toLowerCase());
        }
        return list;
    }
}
