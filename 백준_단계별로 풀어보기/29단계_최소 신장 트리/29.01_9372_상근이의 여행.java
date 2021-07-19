//29.01_9372_상근이의 여행
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            String[] readLine = br.readLine().split(" ");
            int N = Integer.parseInt(readLine[0]);
            int M = Integer.parseInt(readLine[1]);
            for(int m = 0; m < M; m++) {
                readLine = br.readLine().split(" ");
                int a = Integer.parseInt(readLine[0]);
                int b = Integer.parseInt(readLine[1]);
            }
            sb.append(N-1 + "\n");
        }
        System.out.print(sb);
    }
}