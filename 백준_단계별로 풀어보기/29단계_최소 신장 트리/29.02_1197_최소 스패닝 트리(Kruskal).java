import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {
    int a;
    int b;
    int weight;
    Edge(int a, int b, int w) {
        this.a = a;
        this.b = b;
        this.weight = w;
    }

    @Override
    public int compareTo(Edge target) {
        return Integer.compare(this.weight, target.weight);
    }
}

public class Main {
    public static int ans = 0;
    public static int[] parent;
    public static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static int find(int x) {
        if(parent[x] < 0)
            return x;
        else {
            int y = find(parent[x]);
            parent[x] = y;
            return y;
        }
    }

    public static boolean union(int x, int y) {
        int X = find(x);
        int Y = find(y);

        if(X == Y)
            return false;
        if(parent[X] < parent[Y]) {
            parent[X] += parent[Y];
            parent[Y] = X;
        } else {
            parent[Y] += parent[X];
            parent[X] = y;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] readLine = br.readLine().split(" ");
        int V = Integer.parseInt(readLine[0]);
        parent = new int[V+1];
        for(int i = 1; i <= V; i++)
            parent[i] = -1;
        int E = Integer.parseInt(readLine[1]);
        for(int e = 0; e < E; e++) {
            readLine = br.readLine().split(" ");
            pq.offer(new Edge(Integer.parseInt(readLine[0]), Integer.parseInt(readLine[1]),
                    Integer.parseInt(readLine[2])));
        }

        //크루스칼
        //간선 요소들 for문
        int v = 0;
        for(int i = 0; i < E; i++) {
            if(v == V-1)
                break;
            //최소 가중치 간선 선택
            Edge edge = pq.remove();
            //간선 양끝의 노드들이 같은 집합에 속하는지 확인
            if(!union(edge.a, edge.b))
                //속한다면 다음 간선으로 pass
                continue;
            //속하지 않는다면 정답에 넣고(ans가중치 합산) union
            else {
                ans += edge.weight;
                v += 1;
            }
        }
        System.out.println(ans);
    }
}