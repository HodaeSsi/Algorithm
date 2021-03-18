import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static int[][] home;

    //아래 함수 전부 goal 일때나 벽에 닿을때 return 그렇지 않다면 다음 경우의 수들 호출
    //세로 함수
    public static int down(int x, int y) { //매개변수 = 이전좌표
        if(y+1 >= home.length)
            return 0;
        if(home[y+1][x] == 1)
            return 0;
        if(x == home.length-1 && y+1 == home.length-1)
            return 1;

        int temp = 0;
        temp += down(x, y+1);
        temp += rightDown(x, y+1);
        return temp;
    }

    //가로 함수
    public static int right(int x, int y) { //매개변수 = 이전좌표
        if(x+1 >= home.length)
            return 0;
        if(home[y][x+1] == 1)
            return 0;
        if(x+1 == home.length-1 && y == home.length-1)
            return 1;

        int temp = 0;
        temp += right(x+1, y);
        temp += rightDown(x+1, y);
        return temp;
    }

    //대각선 함수
    public static int rightDown(int x, int y) {
        if(x+1 == home.length || y+1 == home.length)
            return 0;
        if(home[y][x+1] == 1 || home[y+1][x] == 1 || home[y+1][x+1] == 1)
            return 0;
        if(x+1 == home.length -1 && y+1 == home.length -1)
            return 1;

        int temp = 0;
        temp += right(x+1, y+1);
        temp += down(x+1, y+1);
        temp += rightDown(x+1, y +1);
        return temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        home = new int[N][N];
        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                home[i][j] = Integer.parseInt(line[j]);
            }
        }

        int answer = 0;
        //첫 재귀로 가로, 대각선 호출
        answer += right(1, 0);
        answer += rightDown(1,0);

        System.out.println(answer);
    }
}