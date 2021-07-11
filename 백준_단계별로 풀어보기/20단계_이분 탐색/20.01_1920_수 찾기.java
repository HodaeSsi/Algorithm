import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static int binarySearch(int[] n, int m ,int s, int e){
        
        if(m == n[s] || m == n[e]){
            return 1;
        }else{
            if(Math.abs(e - s) <= 1){
                return 0;
            }
            int middle = (s + e)/2;
            if(m >= n[middle]){
                s = middle;
            }else{
                e = middle;
            }
            return binarySearch(n, m, s, e);
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] n = new int[N];
        for(int i = 0; i < N; i++){
            n[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        int[] m = new int[M];
        for(int i = 0; i < M; i++){
            m[i] = sc.nextInt();
        }

        Arrays.sort(n);
        int nSize = n.length;
        for(int e : m){
            System.out.println(binarySearch(n, e, 0, nSize-1));
        }
    }
}