import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int[] n = new int[N];
        int K = Integer.parseInt(split[1]);

        for(int i = 0; i < N; i++) {
            n[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        int quo;
        int remain;
        int idx = N-1;
        do {
            quo = K / n[idx];
            answer += quo;
            remain = K % n[idx];
            K %= n[idx];

            idx--;
        } while(remain != 0);

        System.out.println(answer);
    }
}