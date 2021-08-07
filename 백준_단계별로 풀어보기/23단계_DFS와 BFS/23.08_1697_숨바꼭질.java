import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] map = new int[100001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        if(N == K) {
            System.out.println(0);
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);

        boolean isSuccess = false;
        int answer = 0;
        while(true) {
            Integer now = q.poll();
            int temp;
            for(int i = 0; i < 3; i++) {
                if(i == 0) {
                    temp = now +1;
                } else if(i == 1) {
                    temp = now -1;
                } else {
                    temp = now *2;
                }

                if(temp == K) {
                    answer = map[now] +1;
                    isSuccess = true;
                    break;
                }
                if(temp < 0 || temp > 100000)
                    continue;
                if(map[temp] == 0) {
                    map[temp] = map[now] + 1;
                    q.offer(temp);
                }
            }
            if(isSuccess)
                break;
        }

        System.out.println(answer);
    }
}