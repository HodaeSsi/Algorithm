import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<Boolean> visit = new ArrayList<Boolean>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        for(int i = 0; i <= N; i++){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            adjList.add(tmp);
            visit.add(false);
        }
        int M = Integer.parseInt(line[1]);
        int V = Integer.parseInt(line[2]);

        for(int i = 0; i < M; i++){
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        DFS(V);
        System.out.println(sb);
        sb.setLength(0);
        Collections.fill(visit, false);
        BFS(V);
        System.out.println(sb);
    }

    public static void DFS(int startV){
        visit.set(startV, true);
        sb.append(startV + " ");
        ArrayList<Integer> list = adjList.get(startV);
        Collections.sort(list);
        if(!list.isEmpty()){
            for(int e : list)
                if(visit.get(e) == false)
                    DFS(e);
        }
    }

    public static void BFS(int startV) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(startV);
        visit.set(startV, true);
        sb.append(startV + " ");
        while(!q.isEmpty()){
            int here = q.poll();
            ArrayList<Integer> list = adjList.get(here);
            Collections.sort(list);

            if(!list.isEmpty())
                for(int e : list)
                    if(visit.get(e) == false) {
                        q.add(e);
                        visit.set(e, true);
                        sb.append(e + " ");
                    }
        }
    }
}