import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int rowM = Integer.parseInt(split[0]);
        int colN = Integer.parseInt(split[1]);

        int[][] map = new int[colN][rowM];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < colN; i++) {
            split = br.readLine().split(" ");
            for(int j = 0; j < rowM; j++) {
                int temp = Integer.parseInt(split[j]);
                map[i][j] = temp;
                if(temp == 1)
                    q.add(new int[] {i, j});
            }
        }

        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int max = 1;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            for(int i = 0; i < 4; i++) {
                int nextY = now[0] + dir[i][0];
                int nextX = now[1] + dir[i][1];

                if(nextY < 0 || nextY >= colN ||
                nextX < 0 || nextX >= rowM)
                    continue;

                if(map[nextY][nextX] == 0) {
                    map[nextY][nextX] = map[now[0]][now[1]] +1;
                    q.offer(new int[] {nextY, nextX});
                    max = Math.max(max, map[nextY][nextX]);
                }
            }
        }

        boolean isFail = false;
        for(int i = 0; i < colN; i++) {
            for (int j = 0; j < rowM; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    isFail = true;
                    break;
                }
            }
            if(isFail)
                break;
        }
        if(!isFail)
            System.out.println(max -1);
    }
}