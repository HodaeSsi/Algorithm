import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main{
    public static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<Boolean> visit = new ArrayList<Boolean>();
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        for(int i = 0; i <= V; i++){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            adj.add(tmp);
            visit.add(false);
        }
        int E = Integer.parseInt(br.readLine());
        for(int i = 0; i < E; i++) {
            String[] e = br.readLine().split(" ");
            int a = Integer.parseInt(e[0]);
            int b = Integer.parseInt(e[1]);
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        BFS(1);
        System.out.print(answer);
    }

    public static void BFS(int startNode){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(startNode);
        visit.set(startNode, true);
        while(!q.isEmpty()){
            int here = q.poll();
            ArrayList<Integer> tmpList = adj.get(here);
            if(!tmpList.isEmpty())
                for(int e : tmpList) {
                    if (visit.get(e) == false) {
                        q.add(e);
                        answer += 1;
                        visit.set(e, true);
                    }
                }
        }
    }
}