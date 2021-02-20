//29.04_1774_우주신과의 교감
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Vertex {
    int x;
    int y;
    int me;
    int parent;
    Vertex(int x, int y, int vNum) {
        this.x = x;
        this.y = y;
        this.me = vNum;
        this.parent = -1;
    }
}

class Edge implements Comparable<Edge> {
    public Vertex start;
    public Vertex end;
    double weight;
    Edge(Vertex s, Vertex e) {
        this.start = s;
        this.end = e;
        weight = Math.sqrt(Math.pow(s.x - e.x, 2) + Math.pow(s.y - e.y, 2));
    }

    @Override
    public int compareTo(Edge target) {
        return Double.compare(this.weight, target.weight);
    }
}

public class Main {
    public static Vertex[] v;
    public static PriorityQueue<Edge> e = new PriorityQueue<Edge>();

    public static int find(int vNum) {
        if(v[vNum].parent < 0)
            return vNum;
        else {
            int pNum = find(v[vNum].parent);
            v[vNum].parent = pNum;
            return pNum;
        }
    }

    public static boolean union(int vNum1, int vNum2) {
        int pNum1 = find(vNum1);
        int pNum2 = find(vNum2);
        if(pNum1 == pNum2)
            return false;
        if(v[pNum1].parent < v[pNum2].parent) {
            v[pNum1].parent += v[pNum2].parent;
            v[pNum2].parent = pNum1;
        } else {
            v[pNum2].parent += v[pNum1].parent;
            v[pNum1].parent = pNum2;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] readLine = br.readLine().split(" ");
        int N = Integer.parseInt(readLine[0]);
        v = new Vertex[N+1];
        int M = Integer.parseInt(readLine[1]);
        for(int i = 1; i <= N; i++) {
            readLine = br.readLine().split(" ");
            int X = Integer.parseInt(readLine[0]);
            int Y = Integer.parseInt(readLine[1]);
            v[i] = new Vertex(X, Y, i);
        }
        for(int i = 1; i < N; i++)
            for(int j = i+1; j <= N; j++)
                e.offer(new Edge(v[i], v[j]));

        int check = 0;
        double ans = 0.0;
        for(int i = 0; i < M; i++) {
            readLine = br.readLine().split(" ");
            int n1 = Integer.parseInt(readLine[0]);
            int n2 = Integer.parseInt(readLine[1]);
            if(union(n1, n2)) {
                check++;
            }
        }

        //크루스칼
        while(check != N-1) {
            Edge now = e.poll();
            if(union(now.start.me, now.end.me)) {
                check += 1;
                ans += now.weight;
            }
        }
        System.out.println(String.format("%.2f", ans));
    }
}