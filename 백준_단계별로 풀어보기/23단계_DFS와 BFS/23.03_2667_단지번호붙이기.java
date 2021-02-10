import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

public class Main{
    public static int[][] map;
    public static boolean[][] visit;
    public static int answer1 = 0;
    public static ArrayList<Integer> answer2 = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++)
                map[i][j] = Character.getNumericValue(line.charAt(j));
        }

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1 && visit[i][j] == false)
                    BFS(i, j);
            }

        System.out.println(answer1);
        Collections.sort(answer2);
        for(int ans : answer2)
            System.out.println(ans);
    }

    public static void BFS(int startNodeY, int startNodeX){
        answer2.add(0);
        Queue<int[]> q = new LinkedList<int[]>();
        int[] point = {startNodeY, startNodeX};
        q.offer(point);
        answer2.set(answer2.size()-1, answer2.get(answer2.size()-1) +1);
        visit[startNodeY][startNodeX] = true;

        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while(!q.isEmpty()){
            int[] here = q.poll();
            ArrayList<int[]> tmpList = new ArrayList<int[]>();
            for(int[] dir : direction){
                int tempY = here[0] + dir[0];
                int tempX = here[1] + dir[1];
                if(tempY >= 0 && tempY < map.length && tempX >= 0 && tempX < map.length && map[tempY][tempX] == 1){
                    int[] nextNode = {tempY, tempX};
                    tmpList.add(nextNode);
                }
            }
            if(!tmpList.isEmpty())
                for(int[] e : tmpList)
                    if(visit[e[0]][e[1]] == false) {
                        q.offer(e);
                        answer2.set(answer2.size()-1, answer2.get(answer2.size()-1) +1);
                        visit[e[0]][e[1]] = true;
                    }
        }
        answer1 += 1;
    }
}