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
        int heiH = Integer.parseInt(split[2]);

        int[][][] map = new int[heiH][colN][rowM];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < heiH; i++) {
            for(int j = 0; j < colN; j++) {
                split = br.readLine().split(" ");
                for(int k = 0; k < rowM; k++) {
                    map[i][j][k] = Integer.parseInt(split[k]);
                    if(map[i][j][k] == 1)
                        q.add(new int[] {i, j, k});
                }
            }
        }

        int max = 1;
        int[][] dir = {{0, 0, 1}, {0, 1, 0}, {0, 0, -1}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}};
        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int i = 0; i < 6; i++) {
                int tempH = now[0] + dir[i][0];
                int tempC = now[1] + dir[i][1];
                int tempR = now[2] + dir[i][2];

                if(tempH < 0 || tempH >= heiH
                || tempC < 0 || tempC >= colN
                || tempR < 0 || tempR >= rowM)
                    continue;

                if(map[tempH][tempC][tempR] == 0) {
                    map[tempH][tempC][tempR] = map[now[0]][now[1]][now[2]] +1;
                    q.offer(new int[] {tempH, tempC, tempR});
                    max = Math.max(max, map[tempH][tempC][tempR]);
                }
            }
        }

        for(int i = 0; i < heiH; i++) {
            for(int j = 0; j < colN; j++) {
                for(int k = 0; k < rowM; k++) {
                    if(map[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(max -1);
    }
}