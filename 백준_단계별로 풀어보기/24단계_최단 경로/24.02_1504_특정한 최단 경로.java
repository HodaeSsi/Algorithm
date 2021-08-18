import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static List<List<int[]>> adjList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int[] lengthFrom1 = new int[N+1];
        int[] lengthFromV1 = new int[N+1];
        int[] lengthFromV2 = new int[N+1];
        for(int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
            lengthFrom1[i] = Integer.MAX_VALUE;
            lengthFromV1[i] = Integer.MAX_VALUE;
            lengthFromV2[i] = Integer.MAX_VALUE;
        }
        int E = Integer.parseInt(split[1]);
        for(int i = 0; i < E; i++) {
            split = br.readLine().split(" ");
            adjList.get(Integer.parseInt(split[0])).add(new int[] {Integer.parseInt(split[1]), Integer.parseInt(split[2])});
            adjList.get(Integer.parseInt(split[1])).add(new int[] {Integer.parseInt(split[0]), Integer.parseInt(split[2])});
        }

        split = br.readLine().split(" ");
        int v1 = Integer.parseInt(split[0]);
        int v2 = Integer.parseInt(split[1]);

        dijkstra(1, lengthFrom1);
        dijkstra(v1, lengthFromV1);
        dijkstra(v2, lengthFromV2);

        for(int check : new int[] {1, v1, v2, N}) {
            if(lengthFrom1[check] == Integer.MAX_VALUE ||
                    lengthFromV1[check] == Integer.MAX_VALUE ||
                    lengthFromV2[check] == Integer.MAX_VALUE) {
                System.out.println(-1);
                return;
            }
        }

        int answer = lengthFrom1[v1] + lengthFromV1[v2] + lengthFromV2[N];
        answer = Math.min(answer, lengthFrom1[v2] + lengthFromV2[v1] + lengthFromV1[N]);
        System.out.println(answer);
    }

    public static void dijkstra(int start, int[] shortestLengths) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.offer(new int[] {start, 0});
        shortestLengths[start] = 0;

        while(!pq.isEmpty()) {
            int[] now = pq.poll();

            if(shortestLengths[now[0]] < now[1]) continue;

            for(int[] next : adjList.get(now[0])) {
                int toNext = now[1] + next[1];
                if(toNext < shortestLengths[next[0]]) {
                    pq.offer(new int[] {next[0], toNext});
                    shortestLengths[next[0]] = toNext;
                }
            }
        }
    }
}