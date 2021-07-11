import java.util.Scanner;

public class Main{
    public static int M;
    public static int N;
    public static int[][] map;
    public static int[][] DP;

    public static int DFS(int y, int x){
        if(DP[y][x] != -1)
            return DP[y][x];
        else if(y == M-1 && x == N-1)
            return 1;
        else{
            DP[y][x] = 0;
            int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            for(int[] d : direction){
                int newY = y+d[0];
                int newX = x+d[1];
                if(newY >= 0 && newY < M && newX >=0 && newX < N
                    && map[newY][newX] < map[y][x])
                    DP[y][x] += DFS(newY, newX);
            }
            return DP[y][x];
        }
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[M][N];
        DP = new int[M][N];

        for(int i=0; i<M; i++)
            for(int j=0; j<N; j++){
                DP[i][j] = -1;
                map[i][j] = sc.nextInt();
            }

        System.out.println(DFS(0, 0));
    }
}