import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static int parent[];

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
            int tmp = parent[Y];
            parent[Y] = X;
            parent[X] += tmp;
        } else {
            int tmp = parent[X];
            parent[X] = Y;
            parent[Y] += tmp;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] readLine = br.readLine().split(" ");
        int n = Integer.parseInt(readLine[0]);
        parent = new int[n];
        for(int i = 0; i < n; i++)
            parent[i] = -1;
        int m = Integer.parseInt(readLine[1]);

        for(int i = 0; i < m; i++) {
            readLine = br.readLine().split(" ");
            int a = Integer.parseInt(readLine[0]);
            int b = Integer.parseInt(readLine[1]);
            if(!union(a, b)) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(0);
    }
}