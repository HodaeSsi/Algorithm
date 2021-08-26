import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int K = Integer.parseInt(split[0]);
        int N = Integer.parseInt(split[1]);
        long[] k = new long[K];
        for (int i = 0; i < K; i++) {
            k[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(k);
        System.out.println(upperBound(k, N, 1, k[k.length -1] +1L) -1);
    }

    static long upperBound(long[] lumber, int target, long start, long end) {
        long mid;
        while(start < end) {
            mid = (start + end)/2;
            if(cutWood(lumber, mid) >= target)
                start = mid +1;
            else
                end = mid;
        }
        return start;
    }

    static long cutWood(long[] woods, long length) {
        long answer = 0;
        for(long wood : woods) {
            answer += wood/length;
        }
        return answer;
    }
}