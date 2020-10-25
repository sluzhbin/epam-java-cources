package com.epam.university.java.core.task029;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;


public class Task029Impl implements Task029 {

    @Override
    public Collection<String> fillCrossword(Collection<String> rows, Collection<String> words) {
        if (rows == null || words == null) {
            throw new IllegalArgumentException();
        }
        String[] rowsArray = rows.toArray(new String[0]);
        String[] wordsArray = words.toArray(new String[0]);

        String[] result = crosswordJoin(rowsArray, wordsArray);

        return Arrays.asList(result);
    }

    /**
     * Change crosswords according to the word in horizontal.
     * @param ch crossword as arrays
     * @param word word
     * @param limiter limiter
     * @return is it ok to put the word
     */
    public boolean fillHorizontally(char[][] ch, String word, char limiter) {
        int len = word.length();

        for (int i = 0; i < 10; i++) {
            int j = 0;
            POINT:
            while (j <= 10 - len) {
                int k;
                for (k = j; k < j + len; k++) {
                    if (ch[i][k] == limiter) {
                        break;
                    }
                }

                if (k == j + len) {
                    if ((k <= 9 && ch[i][k] != limiter) || (j > 0 && ch[i][j - 1] != limiter)) {
                        j++;
                        continue;
                    }

                    for (k = j; k < j + len; k++) {
                        if (ch[i][k] != '-' && word.charAt(k - j) != ch[i][k]) {
                            j++;
                            continue POINT;
                        }
                    }

                    for (k = j; k < j + len; k++) {
                        ch[i][k] = word.charAt(k - j);
                    }
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    /**
     * Change crosswords according to the word in vertical.
     * @param ch crossword as arrays
     * @param word word
     * @param limiter limiter
     * @return is it ok to put the word
     */
    public boolean fillVertically(char[][] ch, String word, char limiter) {
        int len = word.length();
        for (int i = 0; i < 10; i++) {
            int j = 0;
            POINT:
            while (j <= 10 - len) {
                int k;
                for (k = j; k < j + len; k++) {
                    if (ch[k][i] == limiter) {
                        break;
                    }
                }

                if (k == j + len) {
                    if ((k <= 9 && ch[k][i] != limiter) || (j > 0 && ch[j - 1][i] != limiter)) {
                        j++;
                        continue;
                    }

                    for (k = j; k < j + len; k++) {
                        if (ch[k][i] != '-' && word.charAt(k - j) != ch[k][i]) {
                            j++;
                            continue POINT;
                        }
                    }

                    for (k = j; k < j + len; k++) {
                        ch[k][i] = word.charAt(k - j);
                    }
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    /**
     * Fill crossword with words.
     * @param ch crossword as arrays
     * @param map map of words according to their lengths
     * @param limiter limiter
     */
    public void fill(char[][] ch, Map<Integer, List<String>> map, char limiter) {
        boolean isComplete = true;

        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                isComplete = false;
                break;
            }
        }

        if (isComplete) {
            return;
        }

        char[][] backup = new char[10][10];

        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            List<String> wordList = entry.getValue();
            for (String word : wordList) {
                if (fillHorizontally(ch, word, limiter)
                        || fillVertically(ch, word, limiter)) {
                    List<String> newWordList = new ArrayList<>(entry.getValue());

                    newWordList.remove(word);
                    map.put(entry.getKey(), newWordList);

                    for (int a = 0; a < 10; a++) {
                        System.arraycopy(ch[a], 0, backup[a], 0, 10);
                    }

                    fill(ch, map, limiter);

                    newWordList.add(word);
                    map.put(entry.getKey(),newWordList);

                    for (int a = 0; a < 10; a++) {
                        System.arraycopy(backup[a], 0, ch[a], 0, 10);
                    }
                }
            }
        }
    }

    /**
     * Find crossword as String array.
     * @param crossword  crossword definition as String array
     * @param input words as String array
     * @return filled crossword as String array
     */
    public String[] crosswordJoin(String[] crossword, String[] input) {
        char[][] ch = new char[10][10];
        char limiter = '+';

        for (int i = 0; i < 10; i++) {
            ch[i] = crossword[i].toCharArray();
        }

        Map<Integer, List<String>> map = new HashMap<>();

        for (String word : input) {
            int k = word.length();
            List<String> list;
            if (map.containsKey(k)) {
                list = map.get(k);
            } else {
                list = new ArrayList<>();
            }
            list.add(word);
            map.put(k, list);
        }

        fill(ch, map, limiter);

        for (int i = 0; i < 10; i++) {
            crossword[i] = String.valueOf(ch[i]);
        }

        return crossword;
    }
}
