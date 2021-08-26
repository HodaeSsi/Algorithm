import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        int[] n = new int[N];
        split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            n[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(n);
        System.out.println(upperBound(n, M, 0, n[n.length -1] +1) -1);
    }

    static int upperBound(int[] woods, int target, int start, int end){
        long mid;
        while(start < end) {
            mid = (start + end)/2;
            if(cutWood(woods, mid) >= target) {
                start = (int)mid +1;
            } else {
                end = (int)mid;
            }
        }
        return start;
    }

    static long cutWood(int[] woods, long height) {
        long result = 0;

        for (int wood : woods) {
            long temp = wood - height;
            if(temp > 0)
                result += temp;
        }

        return result;
    }
}
