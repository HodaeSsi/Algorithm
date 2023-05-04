import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] matrices = new int[N][];
        for (int i = 0; i < N; i++) {
            String[] readLine = br.readLine().split(" ");
            matrices[i] = new int[] { Integer.parseInt(readLine[0]), Integer.parseInt(readLine[1]) };
        }

        if (N == 1) {
            System.out.println(0);
        } else if (N == 2) {
            System.out.println(matrices[0][0] * matrices[1][0] * matrices[1][1]);
        } else if (N >= 3) {
            int[][][] minDP = new int[matrices.length][matrices.length][3]; //value, r, c
            int i = 0;
            int j = 0;
            while (j < minDP.length) {
                minDP[i][j][0] = 0;
                minDP[i][j][1] = matrices[i][0];
                minDP[i][j][2] = matrices[i][1];
                i++;
                j++;
            }

            i = 0;
            j = 1;
            while (j < minDP.length) {
                minDP[i][j][0] = matrices[i][0] * matrices[j][0] * matrices[j][1];
                minDP[i][j][1] = matrices[i][0];
                minDP[i][j][2] = matrices[j][1];
                i++;
                j++;
            }

            i = 0;
            j = 2;
            while (j < minDP.length) {
                int _i = i;
                int _j = j;
                while (_j < minDP.length) {
                    minDP[_i][_j][0] = Integer.MAX_VALUE;
                    for (int k = _i; k < _j; k++) {
                        if (minDP[_i][k][0] + minDP[k+1][_j][0] + minDP[_i][k][1] * minDP[k+1][_j][1] * minDP[k+1][_j][2] < minDP[_i][_j][0]) {
                            minDP[_i][_j][0] = minDP[_i][k][0] + minDP[k+1][_j][0] + minDP[_i][k][1] * minDP[k+1][_j][1] * minDP[k+1][_j][2];
                            minDP[_i][_j][1] = minDP[_i][k][1];
                            minDP[_i][_j][2] = minDP[k+1][_j][2];
                        }
                    }
                    _i++;
                    _j++;
                }
                j++;
            }
            System.out.println(minDP[0][minDP.length - 1][0]);
        }

    }
}