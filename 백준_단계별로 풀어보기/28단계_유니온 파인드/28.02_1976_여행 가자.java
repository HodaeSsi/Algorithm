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

    public static void union(int x, int y) {
        int X = find(x);
        int Y = find(y);

        if(X == Y)
            return;
        if(parent[X] < parent[Y]) {
            parent[X] += parent[Y];
            parent[Y] = X;
        } else {
            parent[Y] += parent[X];
            parent[X] = Y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        for(int i = 0; i <= N; i++)
            parent[i] = -1;
        int M = Integer.parseInt(br.readLine());
        int[] m;
        for(int i = 1; i <= N; i++) {
            String[] readLine = br.readLine().split(" ");
            int j = 1;
            for(String e : readLine) {
                if(e.equals("1")) {
                    union(i, j);
                }
                j++;
            }
        }
        String[] readLine = br.readLine().split(" ");
        for(int i = 0; i < M-1; i++)
            if(find(Integer.parseInt(readLine[i])) != find(Integer.parseInt(readLine[i+1]))) {
                System.out.println("NO");
                return;
            }
        System.out.println("YES");
    }
}