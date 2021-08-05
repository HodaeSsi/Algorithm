import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static List<List<Integer>> adjList = new ArrayList<>();
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        for(int i = 0; i < N+1; i++)
            adjList.add(new ArrayList<>());

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            String[] split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int z = Integer.parseInt(split[1]);

            adjList.get(a).add(z);
            adjList.get(z).add(a);
        }

        System.out.println(BFS(1));
    }

    public static int BFS(int start) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visit[start] = true;
//        answer += 1; //1번 컴퓨터는 제외
        while(!q.isEmpty()) {
            Integer now = q.poll();
            List<Integer> nexts = adjList.get(now);
            for(int next : nexts) {
                if(!visit[next]) {
                    q.offer(next);
                    visit[next] = true;
                    answer += 1;
                }
            }
        }

        return answer;
    }
}