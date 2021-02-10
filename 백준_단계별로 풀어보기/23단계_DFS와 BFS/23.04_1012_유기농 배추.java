import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            String[] line = br.readLine().split(" ");
            int rowM = Integer.parseInt(line[0]);
            int colN = Integer.parseInt(line[1]);
            int[][] map = new int[colN][rowM];
            boolean[][] visit = new boolean[colN][rowM];
            int numK = Integer.parseInt(line[2]);
            for(int j = 0; j < numK; j++){
                line = br.readLine().split(" ");
                int X = Integer.parseInt(line[0]);
                int Y = Integer.parseInt(line[1]);
                map[Y][X] = 1;
            }

            int ans = 0;
            int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            for(int j = 0; j < colN; j++){
                for(int k = 0; k < rowM; k++){
                    //BFS
                    if(map[j][k] == 1 && visit[j][k] == false){
                        ans += 1;
                        Queue<int[]> q = new LinkedList<int[]>();
                        int[] point = {j, k};
                        q.offer(point);
                        visit[point[0]][point[1]] = true;
                        while(!q.isEmpty()){
                            ArrayList<int[]> canList = new ArrayList<int[]>();
                            int[] here = q.poll();
                            for(int[] d : dir){
                                int newY = here[0] + d[0];
                                int newX = here[1] + d[1];
                                if(newY >= 0 && newY < colN &&
                                    newX >= 0 && newX < rowM && map[newY][newX] == 1){
                                    int[] newPoint = {newY, newX};
                                    canList.add(newPoint);
                                }
                            }

                            for(int[] next : canList){
                                if(visit[next[0]][next[1]] == false) {
                                    q.add(next);
                                    visit[next[0]][next[1]] = true;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}