import java.util.Scanner;
import java.util.LinkedList;
import java.util.Deque;

public class Main{
    //ArrayList<Character> answer = new ArrayList<Character>();
    Deque<Character> answer = new LinkedList<Character>();

    public void search(int[][] board, int startY, int startX, int maxY, int maxX){
        int firstNum = board[startY][startX];

        if(maxY - startY <= 1 || maxX - startX <= 1){
            answer.addLast(String.valueOf(firstNum).charAt(0));
            return;
        }

        boolean isSearchSuccess = true;
        for(int i = startY; i < maxY; i++){
            for(int j = startX; j < maxX; j++){
                if(board[i][j] != firstNum){
                    answer.addLast('(');
                    search(board, startY, startX, (startY + maxY)/2, (startX + maxX)/2);
                    search(board, startY, (startX + maxX)/2, (startY + maxY)/2, maxX);
                    search(board, (startY + maxY)/2, startX, maxY, (startX + maxX)/2);
                    search(board, (startY + maxY)/2, (startX + maxX)/2, maxY, maxX);
                    answer.addLast(')');
                    isSearchSuccess = false;
                    break;
                }
            }
            if(!isSearchSuccess){
                break;
            }
        }

        if(isSearchSuccess){
            answer.addLast(String.valueOf(firstNum).charAt(0));
        }
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        Main forFunc = new Main();

        int N = sc.nextInt();
        int[][] board = new int[N][N];
        String[] temp = new String[N];

        for(int i = 0; i < N; i++){
            temp[i] = sc.next();
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(String.valueOf(temp[i].charAt(j)));//이거 맞어 ㅋㅋㅋ;;;???
            }
        }

        if(N == 1){
            //System.out.print('(');
            System.out.print(board[0][0]);
            //System.out.print(')');
        }else{
            forFunc.search(board, 0, 0, N, N);
/*
            if(!forFunc.answer.peek().equals('(')){
                forFunc.answer.addFirst('(');
                forFunc.answer.addLast(')');
            }*/
            for(char e : forFunc.answer){
                System.out.print(e);
            }
            //System.out.print('\n');
        }

        //!!!출력관련: 트리나 링크드 리스트 같은 계층 구조로 저장하면 더 쉬울것같은데!!!
        //!!!나중에 이걸로 한번 더 풀기!!!
    }
}