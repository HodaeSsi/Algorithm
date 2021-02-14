import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] n = new int[N];
        String[] readLine = br.readLine().split(" ");
        for(int i = 0; i < N; i++)
            n[i] = Integer.parseInt(readLine[i]);
        Arrays.sort(n);
        int start = 0;
        int end = N-1;
        int[] ans = {Integer.MAX_VALUE, -1, -1};
        while(start < end) {
            int sum = n[start] + n[end];
            if(Math.abs(sum) < ans[0]) { ans[0] = Math.abs(sum); ans[1] = n[start]; ans[2] = n[end]; }
            if(sum > 0) end--;
            else if(sum < 0) start++;
            else break;
        }
        System.out.println(String.format("%d %d", ans[1], ans[2]));
    }
}