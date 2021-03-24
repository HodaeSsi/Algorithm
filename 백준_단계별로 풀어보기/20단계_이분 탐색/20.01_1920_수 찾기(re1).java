import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static int binarySearch(int[] n, int m, int s, int e){
        while(e - s >= 0){
            int middle = (s+e)/2;
            if(n[middle] == m)
                return 1;
            else{
                if(n[middle] <= m){
                    s = middle + 1;
                }else{
                    e = middle - 1;
                }
                return binarySearch(n, m, s, e);
            }
        }
        return 0;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] n = new int[N];
        for(int i = 0; i < N; i++)
            n[i] = sc.nextInt();
        int M = sc.nextInt();
        int[] m = new int[M];
        for(int i = 0; i < M; i++)
            m[i] = sc.nextInt();

        Arrays.sort(n);
        int nSize = n.length;
        for(int e : m)
            System.out.println(binarySearch(n, e, 0, nSize-1));
    }
}