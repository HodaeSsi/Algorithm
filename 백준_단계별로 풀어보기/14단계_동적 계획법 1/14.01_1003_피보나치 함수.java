import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static ArrayList<int[]> DP = new ArrayList<int[]>();

    public static int[] fibo(int n){
        if(n <= DP.size() -1){
            return DP.get(n);
        }else{
            int[] N_1 = fibo(n-1);
            int[] N_2 = fibo(n-2);
            int[] test = {N_1[0] + N_2[0], N_1[1] + N_2[1]};
            DP.add(test);
            return test;
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] N0 = {1, 0};
        DP.add(N0);
        int[] N1 = {0, 1};
        DP.add(N1);
        for(int i = 0; i < T; i++){
            int N = sc.nextInt();
            System.out.print(fibo(N)[0]);
            System.out.print(' ');
            System.out.println(fibo(N)[1]);
        }
    }
}