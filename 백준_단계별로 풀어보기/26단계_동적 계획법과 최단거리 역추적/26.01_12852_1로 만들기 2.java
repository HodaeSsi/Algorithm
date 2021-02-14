import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        DP = new int[N+1][2];
        DP[0][0] = 0;
        DP[0][1] = 0;
        DP[1][0] = 0;
        DP[1][1] = 0;
        for(int i = 2; i <= N; i++) {
            int result1 = DP[i-1][0];
            int result2;
            if(i % 2 != 0)
                result2 = Integer.MAX_VALUE;
            else
                result2 = DP[i/2][0];
            int result3;
            if(i % 3 != 0)
                result3 = Integer.MAX_VALUE;
            else
                result3 = DP[i/3][0];
            DP[i][0] = Math.min(result1, Math.min(result2, result3)) +1;
            if(DP[i][0] == result1+1)
                DP[i][1] = 1;
            else if(DP[i][0] == result2+1)
                DP[i][1] = 2;
            else if(DP[i][0] == result3+1)
                DP[i][1] = 3;
        }
        if(N != 1) {
            System.out.println(DP[N][0]);
            System.out.print(String.format("%d ", N));
            do {
                if (DP[N][1] == 1)
                    N -= 1;
                else if (DP[N][1] == 2)
                    N /= 2;
                else if (DP[N][1] == 3)
                    N /= 3;
                System.out.print(String.format("%d ", N));
            } while (N > 1);
        } else {
            System.out.println(0);
            System.out.println(1);
        }
    }
}