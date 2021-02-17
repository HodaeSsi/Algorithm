import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] parent;

    public static int find(int x) {
        if (parent[x] < 0) {
            return x;
        } else {
            int y = find(parent[x]);
            parent[x] = y;
            return y;
        }
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y)
            return;
        if(parent[x] < parent[y]) {
            parent[x] += parent[y];
            parent[y] = x;
        } else {
            parent[y] += parent[x];
            parent[x] = y;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] readLine = br.readLine().split(" ");
        int n = Integer.parseInt(readLine[0]);
        parent = new int[n+1];
        for(int i = 0; i <= n; i++)
            parent[i] = -1;
        int m = Integer.parseInt(readLine[1]);
        for(int i = 0; i < m; i++) {
            readLine = br.readLine().split(" ");
            int op = Integer.parseInt(readLine[0]);
            int a = Integer.parseInt(readLine[1]);
            int b = Integer.parseInt(readLine[2]);
            if(op == 0) {
                union(a, b);
            }
            else
                if(find(a) == find(b))
                    sb.append("YES\n");
                else
                    sb.append("NO\n");
        }
        System.out.print(sb);
    }
}