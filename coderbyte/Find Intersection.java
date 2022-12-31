package com.hodaessi;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {

    public static String FindIntersection(String[] strArr) {
        // code goes here
        int[] leftArr = Arrays.stream(strArr[0].split(", ")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> rightSet = Stream.of(strArr[1].split(", ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toSet());

        String retainAll = Arrays.stream(leftArr).filter(rightSet::contains).mapToObj(String::valueOf).collect(Collectors.joining(","));

        return retainAll.equals("") ? "false" : retainAll;
    }
}

