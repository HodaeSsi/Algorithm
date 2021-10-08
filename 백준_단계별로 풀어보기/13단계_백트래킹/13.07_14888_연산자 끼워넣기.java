import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        String[] split = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(split[i]);
        }
        int[] opers = new int[4]; //+ - x /
        split = br.readLine().split(" ");
        for(int i = 0; i < 4; i++) {
            opers[i] = Integer.parseInt(split[i]);
        }

        dfs(A, opers, 0, new int[N-1]);
        System.out.println(max);
        System.out.println(min);
    }

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static void dfs(int[] A, int[] opers, int depth, int[] operCase) {
        if(depth == operCase.length) {
            int result = cal(A, operCase);
            if(result < min) {
                min = result;
            }
            if(result > max) {
                max = result;
            }
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(opers[i] == 0) {
                continue;
            }
            operCase[depth] = i;
            opers[i] -= 1;
            dfs(A, opers, depth +1, operCase);
            opers[i] += 1;
        }
    }

    static int cal(int[] A, int[] operCase) {
        int firstNum = A[0];
        for(int i = 1; i < A.length; i++) {
            switch (operCase[i-1]) {
                case 0:
                    firstNum += A[i];
                    break;
                case 1:
                    firstNum -= A[i];
                    break;
                case 2:
                    firstNum *= A[i];
                    break;
                case 3:
                    if(firstNum < 0) {
                        firstNum = (-1) * ((-1) * firstNum / A[i]);
                    } else {
                        firstNum /= A[i];
                    }
                    break;
            }
        }

        return firstNum;
    }
}