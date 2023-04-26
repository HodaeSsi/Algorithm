// https://www.acmicpc.net/problem/9251

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    int temp = Math.min(dp[i-1][j], dp[i][j-1]);
                    temp = Math.min(dp[i-1][j-1], temp);
                    dp[i][j] = temp + 1;
                } else {
                    int temp = Math.max(dp[i-1][j], dp[i][j-1]);
                    temp = Math.max(dp[i-1][j-1], temp);
                    dp[i][j] = temp;
                }
            }
        }

        System.out.println(dp[str1.length()][str2.length()]);
    }
}