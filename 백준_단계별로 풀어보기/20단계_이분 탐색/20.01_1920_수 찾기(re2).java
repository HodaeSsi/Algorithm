import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int[] n;
    public static int[] m;

    public static int BS(int target, int start, int end) {
        if(start < end) {
            int middle = (start + end) /2;

            if(n[middle] == target)
                return 1;
            else if(target < n[middle]) {
                end = middle;
                return BS(target, start, end);
            } else {
                start = middle +1;
                return BS(target, start, end);
            }
        } else {
            if(n[start] == target)
                return 1;
            else
                return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        n = new int[N];
        String[] line = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            n[i] = Integer.parseInt(line[i]);
        }
        int M = Integer.parseInt(br.readLine());
        m = new int[M];
        line = br.readLine().split(" ");
        for(int i = 0; i < M; i++) {
            m[i] = Integer.parseInt(line[i]);
        }

        Arrays.sort(n);
        for(int e: m) {
            System.out.println(BS(e, 0, N-1));
        }
    }
}