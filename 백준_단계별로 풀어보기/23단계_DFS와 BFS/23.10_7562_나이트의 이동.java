import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int I = Integer.parseInt(br.readLine());
            String[] split = br.readLine().split(" ");
            int[] start = new int[] {Integer.parseInt(split[0]), Integer.parseInt(split[1]), 0};
            split = br.readLine().split(" ");
            int[] goal = new int[] {Integer.parseInt(split[0]), Integer.parseInt(split[1])};

            int[][] dir = {{-2, +1}, {-1, +2}, {+1, +2}, {+2, +1},
                    {+2, -1}, {+1, -2}, {-1, -2}, {-2, -1}};
            boolean[][] visit = new boolean[I][I];
            Queue<int[]> q = new LinkedList<>();
            q.offer(start);
            visit[start[0]][start[1]] = true;

            boolean isSuccess = false;
            int answer = 0;
            while(!q.isEmpty()) {
                int[] now = q.poll();

                for(int j = 0; j < 8; j++) {
                    int tempY = now[0] + dir[j][0];
                    int tempX = now[1] + dir[j][1];

                    if(tempY < 0 || tempY >= I || tempX < 0 || tempX >= I || visit[tempY][tempX])
                        continue;
                    if(tempY == goal[0] && tempX == goal[1]) {
                        isSuccess = true;
                        answer = now[2] +1;
                        break;
                    }
                    q.offer(new int[] {tempY, tempX, now[2] +1});
                    visit[tempY][tempX] = true;
                }

                if(isSuccess)
                    break;
            }
            System.out.println(answer);
        }
    }
}