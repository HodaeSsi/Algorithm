import java.util.Scanner;

public class Main{
    public static int[][][][] DP = new int[21][21][21][2];

    public static int w(int a, int b, int c){
        if(a <= 0 || b <= 0 || c <= 0)
            return 1;
        else if(a > 20 || b > 20 || c > 20)
            return w(20, 20, 20);
        else if(a < b && b < c)
            if(DP[a][b][c][0] == 1)
                return DP[a][b][c][1];
            else {
                int tmp = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
                DP[a][b][c][0] = 1;
                DP[a][b][c][1] = tmp;
                return tmp;
            }
        else
            if(DP[a][b][c][0] == 1)
                return DP[a][b][c][1];
            else {
                int tmp = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
                DP[a][b][c][0] = 1;
                DP[a][b][c][1] = tmp;
                return tmp;
            }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(true){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(a == -1 && b == -1 && c == -1)
                break;
            System.out.println(String.format("w(%d, %d, %d) = %d", a, b, c, w(a, b, c)));
        }
    }
}