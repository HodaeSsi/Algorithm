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
        for (int i = 0; i < N; i++) {
            n[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(n);

        int M = Integer.parseInt(br.readLine());
        int[] m = new int[M];
        split = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            m[i] = Integer.parseInt(split[i]);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            stringBuilder.append(upperBound(n, m[i]) - lowerBound(n, m[i])).append(" ");
        }
        System.out.println(stringBuilder);
    }

    static int lowerBound(int[] searchArr, int target) {
        int mid;
        int start = 0;
        int end = searchArr.length;
        while(start < end) {
            mid = (start + end)/2;
            if(searchArr[mid] < target)
                start = mid +1;
            else
                end = mid;
        }
        return start;
    }

    static int upperBound(int[] searchArr, int target) {
        int mid;
        int start = 0;
        int end = searchArr.length;
        while(start < end) {
            mid = (start + end)/2;
            if(searchArr[mid] <= target)
                start = mid +1;
            else
                end = mid;
        }
        return start;
    }
}