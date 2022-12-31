package com.hodaessi;

import java.util.*;
import java.io.*;

class UsernameValidator {

    Set<Integer> numberSet = new HashSet<>();
    Set<Integer> letterSet = new HashSet<>();
    Set<Integer> otherSet = new HashSet<>();

    public UsernameValidator() {

        for (char c = 'a'; c <= 'z'; c++) {
            letterSet.add((int) c);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            letterSet.add((int) c);
        }
        for (char c = '0'; c <= '9'; c++) {
            numberSet.add((int) c);
        }
        otherSet.add((int) '_');
    }

    public boolean codelandUsernameValidation(String str) {

        if (!(str.length() >= 4 && str.length() <= 25)) {
            return false;
        }

        if (!str.chars().allMatch(c -> (letterSet.contains(c) ||
                numberSet.contains(c) ||
                otherSet.contains(c)))) {
            return false;
        }

        if (!letterSet.contains((int) str.charAt(0))) {
            return false;
        }

        if (otherSet.contains((int) str.charAt(str.length() - 1))) {
            return false;
        }

        return true;
    }
}

class Main {
    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        UsernameValidator usernameValidator = new UsernameValidator();

        System.out.print(usernameValidator.codelandUsernameValidation(s.nextLine()));
    }

}