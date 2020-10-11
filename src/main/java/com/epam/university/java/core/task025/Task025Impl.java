package com.epam.university.java.core.task025;

public class Task025Impl implements Task025 {

    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        if (sourceMessage == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= sourceMessage.length() / 3; i++) {
            sb.append("SOS");
        }
        int count = 0;
        for (int i = 0; i < sourceMessage.length(); i++) {
            if (sourceMessage.charAt(i) != sb.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
