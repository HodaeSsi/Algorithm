import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public enum Direction {
        UP, DOWN, RIGHT, LEFT
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int targetNum = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        int fillNum = N*N;
        Direction direction = Direction.DOWN;
        //진행 step 크기
        int stepSize = N;
        //step감소 flag : 0 > 1 > 2가 되면 감소
        int stepFlag = 1;
        int y = -1;
        int x = 0;

        int targetY = 0;
        int targetX = 0;

        //while
        while(fillNum > 0) {
            for(int i = 0; i < stepSize; i++) {
                int[] yx;
                try {
                    yx = doStep_changeYX(direction, y, x);
                    y = yx[0];
                    x = yx[1];
                } catch (Exception e) {
                    System.out.println(e);
                }

                map[y][x] = fillNum;
                if(fillNum == targetNum) {
                    targetY = y+1;
                    targetX = x+1;
                }
                fillNum -= 1;
            }

            try {
                direction = changeDir(direction);
            } catch (Exception e) {
                System.out.println(e);
            }

            stepFlag += 1;
            if(stepFlag == 2) {
                stepSize -= 1;
                stepFlag = 0;
            }
        }

        //배열 출력 및 targetNum yx출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        System.out.println(targetY + " " + targetX);
    }

    static Direction changeDir(Direction preDir) throws Exception {
        if(preDir == Direction.DOWN)
            return Direction.RIGHT;
        if(preDir == Direction.RIGHT)
            return Direction.UP;
        if(preDir == Direction.UP)
            return Direction.LEFT;
        if(preDir == Direction.LEFT)
            return Direction.DOWN;

        throw new Exception("방향 전환 오류");
    }

    static int[] doStep_changeYX(Direction dir, int y, int x) throws Exception {
        switch (dir) {
            case DOWN:
                return new int[] {y+1, x};
            case UP:
                return new int[] {y-1, x};
            case LEFT:
                return new int[] {y, x-1};
            case RIGHT:
                return new int[] {y, x+1};
        }

        throw new Exception("스텝 진행 오류");
    }
}