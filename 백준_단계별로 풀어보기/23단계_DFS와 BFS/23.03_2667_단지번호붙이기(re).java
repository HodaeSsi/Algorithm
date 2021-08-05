import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int [N][N];
        for(int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            int[] temp = new int[N];
            for(int j = 0; j < N; j++) {
                temp[j] = Integer.parseInt(split[j]);
            }
            map[i] = temp;
        }
        visit = new boolean[N][N];

        int dongNum = 0;
        List<Integer> homeNums = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visit[i][j]) {
                    int homeNum = BFS(i, j);
                    homeNums.add(homeNum);
                    dongNum++;
                }
            }
        }

        System.out.println(dongNum);
        Collections.sort(homeNums);
        for (int homeNum : homeNums)
            System.out.println(homeNum);
    }

    public static int BFS(int startY, int startX) {
        int answer = 0;

        Queue<int[]> q = new LinkedList<>();
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};

        int[] temp = {startY, startX};
        q.offer(temp);
        visit[startY][startX] = true;
        answer++;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            for(int i = 0; i < 4; i++) {
                int tempY = now[0] + dy[i];
                int tempX = now[1] + dx[i];
                if(tempY < 0 || tempY >= N || tempX < 0 || tempX >= N)
                    continue;
                if(map[tempY][tempX] == 1 && !visit[tempY][tempX]) {
                    visit[tempY][tempX] = true;
//                    int[] next = {tempY, tempX}; //이걸 while문 위에 temp로 했더니 버그나네;;;
//                    q.offer(next);
                    q.offer(new int[] {tempY, tempX});
                    answer++;
                }
            }
        }

        return answer;
    }
}