package com.hieudd.sample.weather;
import java.util.*;

public class Test {
    public static void main(String args[]) {
        List<String> testCases = Arrays.asList("", "aa", "ab", "aabbbcdddddd", "abbbcdddddd");
        testCases.forEach(r ->{
            if (Test.isAdjacentCharsTheSame(r)) {
                System.out.println(Test.reorder(r));
            }else{
                System.out.println("");
            }
        });

    }

    public static boolean isAdjacentCharsTheSame(String input) {
        if (isEmpty(input)) {
            return false;
        }
        if (input.length() == 1) {
            return true;
        }
        String[] token = input.split("");
        if (token.length == 2 && token[0].equals(token[1])) {
            return false;
        }
        Map<String, Integer> tokenMap = toTokenMap(token);
        int size = input.length();
        int pigeonHole = (size + 2) / 2;
        for (Integer appearanceCount : tokenMap.values()) {
            if (appearanceCount >= pigeonHole) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static String reorder(String input) {
        int length = input.length();
        int[] characterCount = new int[26];
        for (int i = 0; i < length; i++) {
            characterCount[input.charAt(i) - 97] += 1;
        }
        PriorityQueue<CharAppearance> priorityQueue = new PriorityQueue<>(new AppearanceComparator());
        for (int i = 97; i <= 'z'; i++) {
            if ((characterCount[i - 97]) > 0) {
                priorityQueue.add(new CharAppearance((char) i, characterCount[i - 97]));
            }
        }
        StringBuilder result = new StringBuilder();
        CharAppearance prev = new CharAppearance('#', -1);
        while (priorityQueue.size() > 0) {
            CharAppearance charAppearance = priorityQueue.poll();//this method removes and returns the an element from the head of the queue
            result.append(charAppearance.character);
            if (prev.appearanceCount > 0) {
                priorityQueue.add(prev);
            }
            charAppearance.appearanceCount -= 1;
            prev = charAppearance;
        }
        return result.toString();
    }

    public static Map<String, Integer> toTokenMap(String[] token) {
        Map<String, Integer> tokenMap = new HashMap<>();
        for (String r : token) {
            tokenMap.merge(r, 1, Integer::sum);
        }
        return tokenMap;
    }

    static class CharAppearance {
        int appearanceCount;
        char character;

        CharAppearance(char character, int appearanceCount) {
            this.appearanceCount = appearanceCount;
            this.character = character;
        }
    }

    static class AppearanceComparator implements Comparator<CharAppearance> {
        public int compare(CharAppearance o1, CharAppearance o2) {
            if (o1.appearanceCount < o2.appearanceCount)
                return 1;
            else if (o1.appearanceCount > o2.appearanceCount)
                return -1;
            return 0;
        }
    }
}
