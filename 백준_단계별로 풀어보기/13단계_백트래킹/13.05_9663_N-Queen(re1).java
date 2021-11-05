import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] row = new int[N]; //원소값은 0(배치 없음), 1 ~ N

        //배치
        nQueen(row, 0);

        System.out.println(answerNum);
    }

    static int answerNum;
    static void nQueen(int[] map, int depth) {
        if(depth == map.length) {
            answerNum += 1;
            return;
        }
        
        //모든 열에 대한 배치를 수행해 본다
        for(int i = 1; i <= map.length; i++) {
            if(check(map, depth, i)) {
                map[depth] = i;
                nQueen(map, depth +1);
            }
        }
//        map[depth] = 0;
    }

    static boolean check(int[] map, int depth, int col) {
//        for(int i = 0; i < map.length; i++) {
        for(int i = 0; i < depth; i++) {
            //세로 검정
            if(map[i] == col)
                return false;
            //대각선 검정
            if(map[i] != 0) {
                int diffX = Math.abs(i - depth);
                int diffY = Math.abs(map[i] - col);

                if(diffX == diffY)
                    return false;
            }
        }

        return true;
    }
}