import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {
            //그래프 정보 입력
            String[] split = br.readLine().split(" ");
            int V = Integer.parseInt(split[0]);
            int E = Integer.parseInt(split[1]);
            List<Set<Integer>> adjList = new ArrayList<>();
            boolean[] visit = new boolean[V+1];
            for(int j = 0; j < V+1; j++) {
                adjList.add(new HashSet<Integer>());
            }
            for(int j = 0; j < E; j++) {
                split = br.readLine().split(" ");
                adjList.get(Integer.parseInt(split[0])).add(Integer.parseInt(split[1]));
                adjList.get(Integer.parseInt(split[1])).add(Integer.parseInt(split[0]));
            }

            Queue<Integer> q = new LinkedList<>();
            Set<Integer> groupA = new HashSet<>();
            Set<Integer> groupB = new HashSet<>();

            //그래프 순회
            for(int k = 1; k <= V; k++) {
                if(visit[k])
                    continue;
                else{
                    q.add(k);
                    groupA.add(k);
                    visit[k] = true;
                    boolean onOff = true;
                    while(!q.isEmpty()) {
                        int qSize = q.size();
                        for(int j = 0; j < qSize; j++) {
                            Integer now = q.poll();
                            Set<Integer> nexts = adjList.get(now);

                            for (int next : nexts) {
                                if(visit[next])
                                    continue;
                                if(onOff)
                                    groupB.add(next);
                                if(!onOff)
                                    groupA.add(next);
                                q.add(next);
                                visit[next] = true;
                            }
                        }
                        onOff = !onOff;
                    }
                }
            }

            Set<Integer> grouAAdj = new HashSet<>();
            for(int e : groupA) {
                grouAAdj.addAll(adjList.get(e));
            }
            Set<Integer> groupBAdj = new HashSet<>();
            for(int e : groupB) {
                groupBAdj.addAll(adjList.get(e));
            }

            groupA.retainAll(grouAAdj);
            groupB.retainAll(groupBAdj);
            if(groupA.isEmpty() && groupB.isEmpty())
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}