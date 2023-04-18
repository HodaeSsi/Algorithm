// https://school.programmers.co.kr/learn/courses/30/lessons/84021
// TODO: 남의풀이 확인!!!

import java.util.*;
import java.awt.Point;

enum Direction {
    UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1);

    int x;
    int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

enum BoardType {
    INTAGLIO(0), EMBOSSED(1);

    final int value;

    BoardType(int value) {
        this.value = value;
    }

}

class Shape {
    int size;
    Set[] rotations = new HashSet[16]; // TODO: 이거 안먹는다야 ㅋㅋㅋ
    private static final Comparator<Point> pointComparator = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            if (o1.x == o2.x)
                return Integer.compare(o1.y, o2.y);
            else
                return Integer.compare(o1.x, o2.x);
        }
    };

    private static void readjustCenter(Set[] baseRotations, int baseRotationIdx) {
        List<Point> tempForTopLeft = new ArrayList<Point>(baseRotations[baseRotationIdx]);
        tempForTopLeft.sort(pointComparator);
        Point topLeft = tempForTopLeft.get(0);
        int dx = topLeft.x;
        int dy = topLeft.y;

        baseRotations[baseRotationIdx*4] = new HashSet<Point>();
        for (Object point : baseRotations[baseRotationIdx]) {
            baseRotations[baseRotationIdx*4].add(new Point(((Point) point).x - dx, ((Point) point).y - dy));
        }
        for (int i = baseRotationIdx*4+1; i < baseRotationIdx*4+4; i++) {
            baseRotations[i] = new HashSet<Point>();
            for (Object point : baseRotations[i - 1]) {
                baseRotations[i].add(new Point(-((Point) point).y, ((Point) point).x));
            }
        }
    }

    public Shape(Set<Point> originalShape) {
        size = originalShape.size();
        rotations[0] = originalShape;
        for (int i = 1; i < 4; i++) {
            rotations[i] = new HashSet<Point>();
            for (Object point : rotations[i - 1]) {
                rotations[i].add(new Point(-((Point) point).y, ((Point) point).x));
            }
        }

        readjustCenter(rotations, 1);
        readjustCenter(rotations, 2);
        readjustCenter(rotations, 3);
    }

    public static List<Shape> getShapeFromBoard(int[][] board, BoardType boardType) {
        List<Shape> shapes = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!visited[i][j] && board[i][j] == boardType.value) {
                    Set<Point> shape = new HashSet<>();
                    Queue<int[]> q = new LinkedList<>();
                    int dx = i;
                    int dy = j;

                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    while(!q.isEmpty()) {
                        int[] nowNode = q.poll();

                        if (board[nowNode[0]][nowNode[1]] == boardType.value) {
                            shape.add(new Point(nowNode[0] - dx, nowNode[1] - dy));

                            for (Direction direction : Direction.values()) {
                                int nx = nowNode[0] + direction.x;
                                int ny = nowNode[1] + direction.y;

                                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                                    if (!visited[nx][ny]) {
                                        visited[nx][ny] = true;
                                        if (board[nx][ny] == boardType.value) {
                                            q.add(new int[]{nx, ny});
                                        }
                                    }
                                }
                            }
                        }
                    }

                    shapes.add(new Shape(shape));
                }
            }
        }

        return shapes;
    }

    public boolean match(Shape shape) {
        for (int i = 0; i < 16; i++) {
            if (rotations[0].equals(shape.rotations[i])) {
                return true;
            }
        }

        return false;
    }
}

class Solution {
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;

        List<Shape> shapeFromBoard = Shape.getShapeFromBoard(game_board, BoardType.INTAGLIO);
        List<Shape> shapeFromTable = Shape.getShapeFromBoard(table, BoardType.EMBOSSED);

//         print shapeFromBoard
//        System.out.println("shapeFromBoard, " + shapeFromBoard.size());
//        for (Shape shape : shapeFromBoard) {
//            for (int i = 0; i < 1; i++) {
//                System.out.println("rotation " + i);
//                System.out.println(shape.rotations[i]);
//            }
//        }
//
//        System.out.println("shapeFromTable, " + shapeFromTable.size());
//        for (Shape shape : shapeFromTable) {
//            for (int i = 0; i < 1; i++) {
//                System.out.println("rotation " + i);
//                System.out.println(shape.rotations[i]);
//            }
//        }

        for (int i = 0; i < shapeFromTable.size(); i++) {
            for (int j = 0; j < shapeFromBoard.size(); j++) {
                if (shapeFromTable.get(i).match(shapeFromBoard.get(j))) {
                    answer += shapeFromTable.get(i).size;
                    shapeFromBoard.remove(j);
                    break;
                }
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().solution(new int[][]{{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}}, new int[][]{{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}});
    }
}
