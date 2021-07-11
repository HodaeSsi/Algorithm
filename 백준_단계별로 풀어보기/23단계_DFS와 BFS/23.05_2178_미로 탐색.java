import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] readLine = br.readLine().split(" ");
        int colN = Integer.parseInt(readLine[0]);
        int rowM = Integer.parseInt(readLine[1]);
        int[][] map = new int[colN+1][rowM+1];
        boolean[][] visit = new boolean[colN+1][rowM+1];
        for(int i = 1; i <= colN; i++){
            String line = br.readLine();
            for(int j = 1; j <= rowM; j++)
                map[i][j] = Character.getNumericValue(line.charAt(j-1));
        }

        Queue<int[]> q = new LinkedList<int[]>();
        int[] startPoint = {1, 1};
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        q.offer(startPoint);
        visit[startPoint[0]][startPoint[1]] = true;
        Loop1:
        while(!q.isEmpty()){
            int[] here = q.poll();
            //ArrayList<int[]> next = new ArrayList<int[]>();
            for(int[] d : direction){
                int nextY = here[0] + d[0];
                int nextX = here[1] + d[1];
                if(nextY >= 1 && nextY <= colN
                    && nextX >= 1 && nextX <= rowM
                    && map[nextY][nextX] == 1 && visit[nextY][nextX] == false){
                    int[] next = {nextY, nextX};
                    q.offer(next);
                    visit[nextY][nextX] = true;
                    map[nextY][nextX] = map[here[0]][here[1]] +1;
                    if(nextY == colN && nextX == rowM)
                        break Loop1;
                }
            }
        }
        System.out.println(map[colN][rowM]);
    }
}