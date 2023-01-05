package com.hodaessi;

import java.util.*;
import java.io.*;

//TODO 1.남의코드
class Main {
    public static int answerCnt = 0;

    public static void dfs(int maxDepth, int nowDepth, int nonPairLeftBracketNum, int nowBracket) {
        if (nonPairLeftBracketNum == 0 && nowBracket == ')') {
            return;
        }
        if (nonPairLeftBracketNum == maxDepth - nowDepth && nowBracket != ')') {
            return;
        }

        if (nowDepth == maxDepth - 1) {
            answerCnt++;
            return;
        }

        if (nowBracket == ')') {
            nonPairLeftBracketNum -= 1;
        } else {
            nonPairLeftBracketNum += 1;
        }
        dfs(maxDepth, nowDepth + 1, nonPairLeftBracketNum, '(');
        dfs(maxDepth, nowDepth + 1, nonPairLeftBracketNum, ')');
    }

    public static int BracketCombinations(int num) {
        // code goes here
        if (num == 0) {
            return 1;
        }

        dfs(num * 2, 0, 0, '(');
        dfs(num * 2, 0, 0, ')');

        return answerCnt;
    }

    public static void main (String[] args) {
        // keep this function call here

        Scanner s = new Scanner(System.in);
        System.out.print(BracketCombinations(3));
    }

}