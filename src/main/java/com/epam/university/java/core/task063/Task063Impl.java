package com.epam.university.java.core.task063;

public class Task063Impl implements Task063 {

    @Override
    public Integer calcDigitalRoot(Integer number) {
        if (number == null) {
            throw new IllegalArgumentException();
        }
        return Integer.valueOf((1 + (number - 1) % 9));
    }
}
