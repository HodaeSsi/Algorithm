package com.hodaessi;

import java.util.*;
import java.io.*;

class CountMap {

    public Map<String, Integer> countMap = new HashMap<>();

    public CountMap(String str) {
        Arrays.stream(str.split("")).forEach(e -> countMap.put(e, countMap.getOrDefault(e, 0) + 1));
    }

    public boolean hitMe(String bullet) {

        Set<String> ketSet = countMap.keySet();

        Arrays.stream(bullet.split("")).forEach(e -> {
            if (ketSet.contains(e)) {
                countMap.put(e, countMap.get(e) - 1);
            }
        });

        return countMap.values().stream().noneMatch(e -> e > 0);
    }
}

class Main {

    public static String MinWindowSubstring(String[] strArr) {
        // code goes here
        int min = Integer.MAX_VALUE;
        int leftIdx = 0;
        int rightIdx = strArr[0].length();

        for (int i = 0; i < strArr[0].length(); i++) {
            for (int j = i + 1; j <= strArr[0].length(); j++) {
                if (new CountMap(strArr[1]).hitMe(strArr[0].substring(i, j)) && j - i < min) {
                    min = j - i;
                    leftIdx = i;
                    rightIdx = j;
                    break;
                }
            }
        }

        return strArr[0].substring(leftIdx, rightIdx);
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(MinWindowSubstring(new String[] {"aaabaaddae", "aed"}));
    }
}