import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int C = Integer.parseInt(split[1]);
        int[] x = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(x);
        System.out.println(upperBound(x, C, 1, x[x.length -1] - x[0] +1) -1);
    }

    static int upperBound(int[] homes, int target, int start, int end) {
        int mid;
        while(start < end) {
            mid = (start + end)/2;
            if(wifiSet(homes, mid) >= target) {
                start = mid +1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    static int wifiSet(int[] homes, int shortest) {
        int now = 0;
        int cnt = 1;
        for (int i = 1; i < homes.length; i++) {
            if(homes[i] - homes[now] >= shortest) {
                cnt++;
                now = i;
            }
        }

        return cnt;
    }
}