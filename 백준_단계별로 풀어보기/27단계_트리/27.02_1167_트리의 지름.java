import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Node {
    int v, w;
    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

public class Main {
    public static ArrayList<Node>[] ll;
    public static boolean visit[];
    public static int max = 0;
    public static Node infoMax = new Node(0, 0);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] readLine;
        int V = Integer.parseInt(br.readLine());
        ll = new ArrayList[V+1];
        visit = new boolean[V+1];
        for(int i = 0; i <= V; i++)
            ll[i] = new ArrayList<Node>();
        for(int i = 0; i < V; i++) {
            readLine = br.readLine().split(" ");
            boolean onOff = false;
            int j = 1;
            int v = 0;
            int w = 0;
            do {
                if(!onOff) {
                    v = Integer.parseInt(readLine[j]);
                    onOff = true;
                } else {
                    w = Integer.parseInt(readLine[j]);
                    Node tmp = new Node(v, w);
                    ll[Integer.parseInt(readLine[0])].add(tmp);
                    onOff = false;
                }
                j++;
            } while(Integer.parseInt(readLine[j]) != -1);
        }

        visit[1] = true;
        DFS(1, 0);
        Arrays.fill(visit, false);
        visit[infoMax.v] = true;
        DFS(infoMax.v, 0);

        System.out.println(infoMax.w);
    }

    public static void DFS(int Node, int forHere) {
        ArrayList<Node> list = ll[Node];
        for(Node e : list) {
            if (!visit[e.v]) {
                visit[e.v] = true;
                int forThere = forHere + e.w;
                if (forThere > infoMax.w) {
                    infoMax.v = e.v;
                    infoMax.w = forThere;
                }
                DFS(e.v, forThere);
            }
        }
    }
}