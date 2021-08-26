import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] n = new int[N];
        String[] split = br.readLine().split(" ");
        for(int i = 0; i < N; i++)
            n[i] = Integer.parseInt(split[i]);

        int M = Integer.parseInt(br.readLine());
        int[] m = new int[M];
        split = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            m[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(n);
        for (int i = 0; i < M; i++) {
            int result = Arrays.binarySearch(n, m[i]);
            if(result >= 0)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}