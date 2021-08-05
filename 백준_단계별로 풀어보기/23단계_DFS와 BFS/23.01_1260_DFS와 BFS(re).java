import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static List<List<Integer>> lines = new ArrayList<>();
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] readLine = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(readLine[0]);
        int M = Integer.parseInt(readLine[1]);
        int V = Integer.parseInt(readLine[2]);

        for(int i = 0; i < N; i++) {
            ArrayList<Integer> tmpList = new ArrayList<>();
            lines.add(tmpList);
        }
        visit = new boolean[N];
        for(int i = 0; i < M; i++) {
            readLine = bufferedReader.readLine().split(" "); //한번에 Integer.parseInt 적용 못하나? (map이나 람다식???)
            int a = Integer.parseInt(readLine[0]);
            int z = Integer.parseInt(readLine[1]);

            lines.get(a-1).add(z);
            lines.get(z-1).add(a);
        }

        //DFS
        DFS(V);
        for(int e : dfsAnswer)
            System.out.print(e + " ");
        System.out.print("\n");

        Arrays.fill(visit, false);

        //BFS
        BFS(V);
        for(int e : bfsAnswer)
            System.out.print(e + " ");
        System.out.print("\n");
    }

    public static List<Integer> dfsAnswer = new ArrayList<>();
    public static void DFS(int now) {

        dfsAnswer.add(now);
        List<Integer> nextList = lines.get(now-1);
        Collections.sort(nextList);
        visit[now-1] = true;
        for(int next : nextList) {

            if(!visit[next-1])
                DFS(next);
        }
    }

    public static List<Integer> bfsAnswer = new ArrayList<>();
    public static void BFS(int start) {

        visit[start -1] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {

            Integer now = q.poll();
            bfsAnswer.add(now);
            List<Integer> nextList = lines.get(now - 1);
            Collections.sort(nextList);
            for(int next : nextList) {
                if(!visit[next -1]) {
                    q.add(next);
                    visit[next -1] = true;
                }
            }
        }
    }
}