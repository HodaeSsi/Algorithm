import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static ArrayList<Integer>[] linkedList;
    static boolean[] visit;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        linkedList = new ArrayList[N+1];
        visit = new boolean[N+1];
        parent = new int[N+1];
        for(int i = 0; i <= N; i++)
            linkedList[i] = new ArrayList<Integer>();
        for(int i = 0; i < N-1; i++) {
            String[] readLine = br.readLine().split(" ");
            int a = Integer.parseInt(readLine[0]);
            int b = Integer.parseInt(readLine[1]);
            linkedList[a].add(b);
            linkedList[b].add(a);
        }

        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(1);
        visit[1] = true;
        parent[1] = 0;
        while(!q.isEmpty()) {
            int here = q.poll();
            for(int e : linkedList[here]) {
                if(!visit[e]) {
                    q.offer(e);
                    visit[e] = true;
                    parent[e] = here;
                }
            }
        }

        for(int i = 2; i <= N; i++)
            System.out.println(parent[i]);
    }
}