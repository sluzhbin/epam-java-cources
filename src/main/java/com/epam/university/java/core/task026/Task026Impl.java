package com.epam.university.java.core.task026;

public class Task026Impl implements Task026 {

    @Override
    public String encrypt(String sourceString, int shift) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        char[] chars = sourceString.toCharArray();
        int[] ints = new int[chars.length];
        for (int j = 0; j < ints.length; j++) {
            ints[j] = chars[j] - 0;
            if(Character.isAlphabetic(chars[j]) && Character.isUpperCase(chars[j])){
                ints[j] = (chars[j] + shift % 26 - 65) % 26 + 65;
            } else if(Character.isAlphabetic(chars[j]) && Character.isLowerCase(chars[j])) {
                ints[j] = (chars[j] + shift % 26 - 97) % 26 + 97;
            }
        }
        char[] newChar = new char[ints.length];
        for (int j = 0; j < newChar.length; j++) {
            newChar[j] = (char) ints[j];
        }
        return new String(newChar);
    }

    @Override
    public String decrypt(String encryptedString, int shift) {
        shift = shift % 26;
        char[] chars = encryptedString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isLetter(chars[i])) {
                continue;
            }
            int gap;
            if (Character.isUpperCase(chars[i])) {
                gap = 65;
            } else {
                gap = 97;
            }
            int newPos = chars[i] - shift - gap;
            if (newPos >= 0) {
                chars[i] = (char) (newPos % 26 + gap);
            } else {
                chars[i] = (char) (newPos + gap + 26);
            }
        }
        return String.valueOf(chars);
    }
}
