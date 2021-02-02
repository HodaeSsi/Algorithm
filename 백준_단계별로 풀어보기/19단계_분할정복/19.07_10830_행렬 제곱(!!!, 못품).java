import java.util.Scanner;
import java.util.ArrayList;

//!!! 자바 배열이랑 함수 매개변수로서의 배열 공부좀;; !!!
//!!! 나머지 연산 분배법칙 !!!
//!!! 자바 static ㅠㅠㅠ !!!

public class Main{
    public long[][] NM(long[][] N, long [][] M){ //static하면 forFunc필요없네
        int colSize = N[0].length;
        long[][] result = new long[colSize][colSize];
        for(int i = 0; i < colSize; i++){
            for(int j = 0; j < colSize; j++){
                long tmp = 0;
                for(int k = 0; k < colSize; k++){
                    tmp += (N[i][k] * M[k][j]) % 1000;
                }
                result[i][j] = tmp % 1000;
            }
        }

        return result;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Main forFunc = new Main();
        int N = sc.nextInt();
        long B = sc.nextLong();

        ArrayList<Integer> kList = new ArrayList<Integer>();

        long[][] A = new long[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                A[i][j] = sc.nextInt();
            }
        }

        int k = 1;
        long tmp = 2;
        while(!(B <= 1)){
            //비트 연산으로 다시 !!!
            if (B < tmp){
                kList.add(k-1);
                B -= tmp/2;
                k = 1;
                tmp = 2;
            }else if(B == tmp){
                kList.add(k);
                B = 0;
            }else {
                k++;
                tmp *= 2;
            }
        }
        if(B == 1) {
            kList.add(0);
        }

        ArrayList<long[][]> matrixList = new ArrayList<long[][]>();
        while(!(kList.isEmpty())){
            for(int i = 0; i < kList.size(); i++){
                if(kList.get(i) == 0){
                    matrixList.add(A);
                    kList.remove(i);
                }
                if(!(i == kList.size())) {
                    kList.set(i, kList.get(i) - 1);
                }
            }
            A = forFunc.NM(A, A);
        }

        for(int i = 1; i < matrixList.size(); i++){
            matrixList.set(0, forFunc.NM(matrixList.get(0), matrixList.get(i)));
        }

        for(long[] row : matrixList.get(0)){
            for(long e : row){
                System.out.print(e%1000);
                System.out.print(' ');
            }
            System.out.print('\n');
        }
    }
}