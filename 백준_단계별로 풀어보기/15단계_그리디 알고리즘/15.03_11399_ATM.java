import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int[] pI = new int[N];
        for(int i = 0; i < N; i++) {
            pI[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(pI);

        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += pI[i] * (N - i);
        }

        System.out.println(sum);
    }
}