import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Vortex {
    double x;
    double y;
    int parent;
    int me;
    Vortex(double x, double y, int vNum) {
        this.x = x;
        this.y = y;
        this.parent = -1;
        this.me = vNum;
    }
}

class Edge implements Comparable<Edge> {

    Vortex start;
    Vortex end;
    double weight;
    Edge(Vortex s, Vortex e) {
        this.start = s;
        //헷갈린다 헷갈려
        this.end = e;
        weight = Math.sqrt(Math.pow(Math.abs(e.x - s.x), 2) + Math.pow(Math.abs(e.y - s.y), 2));
    }

    @Override
    public int compareTo(Edge target) {
        return Double.compare(this.weight, target.weight);
    }

    @Override
    public String toString() {
        return "s: {" + start.x + ", " + start.y + "}, e: {" + end.x + ", " + end.y + "}, w: " + weight + "\n";
    }
}

public class Main {
    public static Vortex[] v;
    public static PriorityQueue<Edge> e = new PriorityQueue<>();

    public static int find(int vNum) {
        if(v[vNum].parent < 0)
            return v[vNum].me;
        else {
            int pNum = find(v[vNum].parent);
            v[vNum].parent = pNum;
            return pNum;
        }
    }

    public static boolean union(Vortex s, Vortex e) {
        int S = find(s.me);
        int E = find(e.me);
        if(S == E)
            return false;
        if(v[S].parent < v[E].parent) {
            v[S].parent += v[E].parent;
            v[E].parent = v[S].me;
        } else {
            v[E].parent += v[S].parent;
            v[S].parent = v[E].me;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        v = new Vortex[n];
        for(int i = 0; i < n; i++) {
            String[] readLine = br.readLine().split(" ");
            v[i] = new Vortex(Double.parseDouble(readLine[0]), Double.parseDouble(readLine[1]), i);
        }

        for(int i = 0; i < n-1; i++)
            for(int j = i+1; j < n; j++)
                e.offer(new Edge(v[i], v[j]));

        //System.out.println(e.toString());
        //toString이랑 콜렉션?(리스트 등...) 원소 출력의 원리???

        double ansW = 0.0;
        //크루스칼
        int countE = 0;
        while(countE != n-1) {
            Edge now = e.poll();
            if(union(now.start, now.end)) {
                countE += 1;
                ansW += now.weight;
            }
        }
        System.out.println(String.format("%.2f", ansW));
    }
}