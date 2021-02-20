//29.05_2887_행성 터널
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Planet {
    int me;
    int parent;
    Planet(int me) {
        this.me = me;
        this.parent = -1;
    }
}

class Edge implements Comparable<Edge> {
    int pNum1;
    int pNum2;
    int weight;
    Edge(int s, int e, int w) {
        this.pNum1 = s;
        this.pNum2 = e;
        this.weight = w;
    }

    @Override
    public int compareTo(Edge target) {
        return Integer.compare(this.weight, target.weight);
    }
}

public class Main {
    public static Planet[] planet;
    public static int[][] xList;
    public static int[][] yList;
    public static int[][] zList;
    public static PriorityQueue<Edge> edge = new PriorityQueue<Edge>();

    public static int find(int pNum) {
        if(planet[pNum].parent < 0)
            return pNum;
        else {
            int y = find(planet[pNum].parent);
            planet[pNum].parent = y;
            return y;
        }
    }

    public static boolean union(int pNum1, int pNum2) {
        int parent1 = find(pNum1);
        int parent2 = find(pNum2);
        if(parent1 == parent2)
            return false;
        if(planet[parent1].parent < planet[parent2].parent) {
            planet[parent1].parent += planet[parent2].parent;
            planet[parent2].parent = planet[parent1].me;
        } else {
            planet[parent2].parent += planet[parent1].parent;
            planet[parent1].parent = planet[parent2].me;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        planet = new Planet[N];
        for(int i = 0; i < N; i++)
            planet[i] = new Planet(i);
        xList = new int[N][2];
        yList = new int[N][2];
        zList = new int[N][2];
        for(int n = 0; n < N; n++) {
            String[] readLine = br.readLine().split(" ");
            xList[n][0] = Integer.parseInt(readLine[0]);
            xList[n][1] = n;
            yList[n][0] = Integer.parseInt(readLine[1]);
            yList[n][1] = n;
            zList[n][0] = Integer.parseInt(readLine[2]);
            zList[n][1] = n;
        }
        Arrays.sort(xList, new Comparator<int[]>() { //!!! 람다식으로 줄일 수 있음 !!!
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1]; // !!!이게 어떻게 order의 기준으로서 반환 될 수가 있는거지;;; !!!
                } else {
                    return o1[0] - o2[0]; // !!!원리? 방식? 하나도 모르겠다 !!!
                }
            }
        });
        Arrays.sort(yList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1]; // !!!이게 어떻게 order의 기준으로서 반환 될 수가 있는거지;;; !!!
                } else {
                    return o1[0] - o2[0]; // !!!원리? 방식? 하나도 모르겠다 !!!
                }
            }
        });
        Arrays.sort(zList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1]; // !!!이게 어떻게 order의 기준으로서 반환 될 수가 있는거지;;; !!!
                } else {
                    return o1[0] - o2[0]; // !!!원리? 방식? 하나도 모르겠다 !!!
                }
            }
        });

        for(int i = 0; i < N-1; i++) {
            edge.offer(new Edge(xList[i][1], xList[i+1][1], Math.abs(xList[i][0] - xList[i+1][0])));
            edge.offer(new Edge(yList[i][1], yList[i+1][1], Math.abs(yList[i][0] - yList[i+1][0])));
            edge.offer(new Edge(zList[i][1], zList[i+1][1], Math.abs(zList[i][0] - zList[i+1][0])));
        }

        //크루수칼
        int count = 0;
        int ans = 0;
        while(count != N-1) {
            Edge now = edge.poll();
            if(union(now.pNum1, now.pNum2)) {
                count++;
                ans += now.weight;
            }
        }
        System.out.println(ans);
    }
}