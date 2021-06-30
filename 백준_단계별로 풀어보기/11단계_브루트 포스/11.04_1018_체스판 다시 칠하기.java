import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N, M;
    public static char board[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] readLine = br.readLine().split(" ");
        N = Integer.parseInt(readLine[0]);
        M = Integer.parseInt(readLine[1]);
        board = new char[N][M];

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            String temp = br.readLine();
            for(int j = 0; j < M; j++){
                board[i][j] = temp.charAt(j);
            }
        }

        int temp = 0;
        for(int i = 0; i < N-8 +1; i++){
            for(int j = 0; j < M-8 +1; j++) {
                for(int k = i; k < i + 8; k++) {
                    for(int l = j; l < j + 8; l++) {
                        if(k%2 == 0) {
                            if(l%2 == 0) {
                                if(board[k][l] != 'B')
                                    temp++;
                            } else {
                                if(board[k][l] != 'W')
                                    temp++;
                            }
                        } else {
                            if(l%2 == 0) {
                                if(board[k][l] != 'W')
                                    temp++;
                            } else {
                                if(board[k][l] != 'B')
                                    temp++;
                            }
                        }
                    }
                }
                min = Math.min(min, temp);
                temp = 0;
                for(int k = i; k < i + 8; k++) {
                    for(int l = j; l < j + 8; l++) {
                        if(k%2 == 0) {
                            if(l%2 == 0) {
                                if(board[k][l] != 'W')
                                    temp++;
                            } else {
                                if(board[k][l] != 'B')
                                    temp++;
                            }
                        } else {
                            if(l%2 == 0) {
                                if(board[k][l] != 'B')
                                    temp++;
                            } else {
                                if(board[k][l] != 'W')
                                    temp++;
                            }
                        }
                    }
                }
                min = Math.min(min, temp);
                temp = 0;
            }
        }

        System.out.println(min);

//        for(char[] boardLine : board) {
//            for(char e : boardLine) {
//                System.out.println(e + " ");
//            }
//            System.out.println('\n');
//        }
    }
}