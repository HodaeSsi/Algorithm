import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        String[] split = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(split[i]);
        }

        int[] maxValues = new int[N];
        maxValues[0] = 1;
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                //maxValues[j]에 대해서,
                //A[i] > A[j]
                if(A[i] > A[j]) {
                    if(maxValues[j] + 1 > maxValues[i])
                        maxValues[i] = maxValues[j] + 1;
                }
                //A[i] == A[j]
                else if(A[i] == A[j]) {
                    if(maxValues[j] > maxValues[i])
                        maxValues[i] = maxValues[j];
                }
                //A[i] < A[j]
                else {
                    if(1 > maxValues[i])
                        maxValues[i] = 1;
                }
            }
        }

        Arrays.sort(maxValues);
        System.out.println(maxValues[maxValues.length -1]);
    }
}