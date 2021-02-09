import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int[][] adjMatrix;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int V = Integer.parseInt(line[2]);
        adjMatrix = new int[N+1][N+1];
        visit = new boolean[N+1];
        for(int i=0; i<M; i++){
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            adjMatrix[a][b] =1;
            adjMatrix[b][a] =1;
        }
        DFS(V);
        System.out.println();
        Arrays.fill(visit, false);
        BFS(V);

    }

    public static void DFS(int startNode){
        visit[startNode] = true;
        System.out.print(startNode + " ");
        for(int i = 1; i<adjMatrix[0].length; i++)
            if(adjMatrix[startNode][i] == 1 && visit[i] == false)
                DFS(i);
    }

    public static void BFS(int startNode){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(startNode);
        visit[startNode] = true;
        while(!q.isEmpty()){
            int here = q.poll();
            System.out.print(here + " ");

            for(int i=1; i<adjMatrix[0].length; i++){
                if(adjMatrix[here][i] == 1 && visit[i] == false){
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
}