import java.util.Scanner;

public class Main{
    public int w = 0;
    public int b = 0;

    //탐색(재귀)
    //탐색 실패: 정사각형이 아니면 자르기
    //탐색 성공: 결과 반환
    public void search(int[][] board, int s_y, int s_x, int m_y, int m_x){
        int firstValue = board[s_y][s_x];
        /*
        if(m_y - s_y <= 1 || m_x - s_x <= 1){
            if(firstValue == 0){
                this.w++;
            }else{
                this.b++;
            }
            return;
        }*/

        boolean searchFail = false;
        for(int i = s_y; i < m_y; i++){
            for(int j = s_x; j < m_x; j++){
                if(board[i][j] != firstValue){
                    if(m_y - s_y == 2 || m_x - s_x == 2){
                        for(int k = s_y; k < m_y; k++){
                            for(int l = s_x; l < m_x; l++){
                                if(board[k][l] == 0){
                                    this.w++;
                                }else{
                                    this.b++;
                                }
                            }
                        }
                    }else{
                        search(board, s_y, s_x, (s_y + m_y) / 2, (s_x + m_x) / 2);
                        search(board, s_y, (s_x + m_x) / 2, (s_y + m_y) / 2, m_x);
                        search(board, (s_y + m_y) / 2, s_x, m_y, (s_x + m_x) / 2);
                        search(board, (s_y + m_y) / 2, (s_x + m_x) / 2, m_y, m_x);
                    }
                    searchFail = true;
                    break;
                }
            }
            if(searchFail){
                break;
            }
        }

        if(!searchFail) {
            if (firstValue == 0) {
                this.w++;
            } else {
                this.b++;
            }
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] board = new int[N][N];

        Main forFunc = new Main();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                board[i][j] = sc.nextInt();
            }
        }
/*
        for(int[] row : board){
            for(int e : row){
                System.out.print(e);
                System.out.print(' ');
            }
            System.out.println(' ');
        }*/

        forFunc.search(board, 0, 0, N, N);

        System.out.println(forFunc.w);
        System.out.print(forFunc.b);
    }
}