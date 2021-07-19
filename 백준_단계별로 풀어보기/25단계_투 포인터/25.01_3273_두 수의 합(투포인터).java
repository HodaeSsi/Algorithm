import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] readLine = br.readLine().split(" ");
        int[] n = new int[N];
        for(int i = 0; i < N; i++)
            n[i] = Integer.parseInt(readLine[i]);
        int X = Integer.parseInt(br.readLine());

        Arrays.sort(n);
        int startPoint = 0;
        int endPoint = N-1;
        int ans = 0;
        while(startPoint < endPoint){
            int predicted = n[startPoint] + n[endPoint];
            if(predicted == X) { endPoint--; ans++; }
            else if(predicted < X) startPoint++;
            else endPoint--;
        }
        System.out.println(ans);
    }
}