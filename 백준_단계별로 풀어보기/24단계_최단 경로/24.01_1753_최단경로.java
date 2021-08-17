import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int V = Integer.parseInt(split[0]);
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }
        int E = Integer.parseInt(split[1]);
        int start = Integer.parseInt(br.readLine());
        for(int i = 0; i < E; i++) {
            split = br.readLine().split(" ");
            adjList.get(Integer.parseInt(split[0])).add(new int[] {Integer.parseInt(split[1]), Integer.parseInt(split[2])});
        }

        int[] shortestLengthArr = new int[V+1];
        Arrays.fill(shortestLengthArr, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); //(Comparator.comparingInt(o -> o[1]));
        pq.offer(new int[]{start, 0});
        shortestLengthArr[start] = 0;
        while(!pq.isEmpty()) {
            int[] now = pq.poll();

            if(now[1] < shortestLengthArr[now[0]]) continue;

            for(int[] next : adjList.get(now[0])) {
                int nextLength = now[1] + next[1];
                if(nextLength < shortestLengthArr[next[0]]) {
                    shortestLengthArr[next[0]] = nextLength;
                    pq.offer(new int[]{next[0], nextLength});
                }
            }
        }

        for(int i = 1; i < shortestLengthArr.length; i++) {
            if(shortestLengthArr[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(shortestLengthArr[i]);
        }
    }
}