// https://www.acmicpc.net/problem/12865

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");

        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        int[][] dp = new int[N][K+1];

        String[] WV = br.readLine().split(" ");
        int W = Integer.parseInt(WV[0]);
        int V = Integer.parseInt(WV[1]);
        for (int i = 1; i <= K; i++) {
            if (i >= W) {
                dp[0][i] = V;
            }
        }
        for (int i = 1; i < N; i++) {
            WV = br.readLine().split(" ");
            W = Integer.parseInt(WV[0]);
            V = Integer.parseInt(WV[1]);
            for (int j = 1; j <= K; j++) {
                if (j < W) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-W] + V, dp[i-1][j]);
                }
            }
        }

        System.out.println(dp[N-1][K]);
    }
}