import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] readLine = br.readLine().split(" ");
        int rowM = Integer.parseInt(readLine[0]);
        int colN = Integer.parseInt(readLine[1]);
        int[][] map = new int[colN][rowM];
        Queue<int[]> q = new LinkedList<int[]>();
        for(int i = 0; i < colN; i++){
            readLine = br.readLine().split(" ");
            for(int j = 0; j < rowM; j++){
                map[i][j] = Integer.parseInt(readLine[j]);
                if(map[i][j] == 1){
                    int[] tmp = {i, j};
                    q.add(tmp);
                }
            }
        }

        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int ans = 0;
        while(!q.isEmpty()){
            int[] here = q.poll();
            for(int[] d : direction){
                int[] next = {here[0] + d[0], here[1] + d[1]};
                if(next[0] >= 0 && next[0] < colN &&
                        next[1] >= 0 && next[1] < rowM && map[next[0]][next[1]] == 0){
                    q.offer(next);
                    map[next[0]][next[1]] = map[here[0]][here[1]] +1;
                }
            }
            ans = Math.max(ans, map[here[0]][here[1]]);
        }
        for(int i = 0; i < colN; i++)
            for(int j = 0; j < rowM; j++)
                if(map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
        System.out.println(ans-1);
    }
}