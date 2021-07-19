import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] A = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                A[i][j] = sc.nextInt();
            }
        }

        M = sc.nextInt();
        int K = sc.nextInt();
        int[][] B = new int[M][K];

        for(int i = 0; i < M; i++){
            for(int j = 0; j < K; j++){
                B[i][j] = sc.nextInt();
            }
        }

        int[][] ans = new int[N][K];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < K; j++){
                int tmp = 0;
                for(int k = 0; k < M; k++){
                    tmp += A[i][k] * B[k][j];
                }
                ans[i][j] = tmp;
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < K; j++){
                System.out.print(ans[i][j]);
                System.out.print(' ');
            }
            System.out.print('\n');
        }
    }
}