import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split("");
        int[][] board = new int[line.length][line.length];
        for(int i = 0; i < line.length; i++) {
            board[0][i] = Integer.parseInt(line[i]);
        }
        for(int i = 1; i < board[0].length; i++) {
            line = br.readLine().split("");
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        line = br.readLine().split("");
        int[] moves = new int[line.length];
        for(int i = 0; i < moves.length; i++) {
            moves[i] = Integer.parseInt(line[i]);
        }

        int answer = solution(board, moves);
        System.out.println(answer);
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Stack<Integer>> newBoard = new ArrayList<>();
        newBoard.add(new Stack<Integer>());

        for(int i = 0; i < board.length; i++) {
            Stack<Integer> tempStack = new Stack<>();
            for(int j = board.length -1; j >= 0; j--) {
                if(board[j][i] != 0)
                    tempStack.add(board[j][i]);
            }
            newBoard.add(tempStack);
        }
//        for(Stack<Integer> stack : newBoard) {
//            System.out.println(stack.toString());
//        }

        Stack<Integer> answerStack = new Stack<>();

        for(int e : moves) {
            Integer now;
            if(!newBoard.get(e).isEmpty()) {
                now = newBoard.get(e).pop();

                Integer top;
                if(!answerStack.isEmpty()) {
                    top = answerStack.peek();
                    if(now.equals(top)) {
                        answerStack.pop();
                        answer += 2;
                    } else {
                        answerStack.push(now);
                    }
                } else {
                    answerStack.push(now);
                }
            }
        }

        return answer;
    }
}