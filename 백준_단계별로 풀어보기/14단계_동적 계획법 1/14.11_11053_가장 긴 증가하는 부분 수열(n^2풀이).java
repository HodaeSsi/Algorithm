import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    public static ArrayList<Integer> DP = new ArrayList<Integer>();

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] n = new int[N];
        for(int i = 0; i < N; i++)
            n[i] = sc.nextInt();

        DP.add(1);
        for(int i = 1; i < N; i++){
            int tmpMax = 0;
            for(int j = 0; j < i; j++){
                if(n[i] > n[j]){
                    if(DP.get(j) > tmpMax){
                        tmpMax = DP.get(j);
                    }
                }
            }
            DP.add(tmpMax +1);
        }

        System.out.println(Collections.max(DP));
    }
}