import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int[] n;
    public static int[] m;

    public static int ParametricSearch(int target, int start, int end) {
        int lb = LowerBound(target, start, end);
        int ub = UpperBound(target, start, end);
        if(lb == ub)
            return 0;
        else
            return ub - lb;
    }

    public static int LowerBound(int target, int start, int end) {
        int middle;
        while(start < end) {
            middle = (start + end) /2;
            if(n[middle] < target)
                start = middle +1;
            else
                end = middle;
        }
        return start;
    }

    public static int UpperBound(int target, int start, int end) {
        int middle;
        while(start < end) {
            middle = (start + end) /2;
            if(n[middle] <= target)
                start = middle +1;
            else
                end = middle;
        }
        return start;
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
        StringBuilder sb = new StringBuilder();
        for(int e: m) {
            sb.append(ParametricSearch(e, 0, N));
            sb.append(" ");
        }
        System.out.println(sb);
    }
}