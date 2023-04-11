// https://school.programmers.co.kr/learn/courses/30/lessons/178870
// TODO: 남의 풀이 확인!!!

import java.util.*;

class Solution {
    public static List<int[]> candidates = new ArrayList<>(); //idx, length, left, right
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};

        int leftPointer = 0;
        int rightPointer = 0;
        int tempSum = sequence[0];

        while (true) {
            if (tempSum < k) {
                if (rightPointer + 1 == sequence.length) {
                    break;
                } else {
                    rightPointer++;
                    tempSum += sequence[rightPointer];
                }
            } else if (tempSum > k) {
                if (leftPointer < rightPointer) {
                    tempSum -= sequence[leftPointer];
                    leftPointer++;
                } else {
                    if (rightPointer + 1 == sequence.length) {
                        break;
                    } else {
                        rightPointer++;
                        tempSum += sequence[rightPointer];
                    }
                }
            } else {
                candidates.add(new int[]{leftPointer, rightPointer - leftPointer + 1, leftPointer, rightPointer});
                if (rightPointer + 1 == sequence.length) {
                    if (leftPointer + 1 != sequence.length) {
                        tempSum -= sequence[leftPointer];
                        leftPointer++;
                    } else {
                        break;
                    }
                } else {
                    rightPointer++;
                    tempSum += sequence[rightPointer];
                }
            }
        }

        candidates.sort((a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        int[] myAnswer = candidates.get(0);
        answer = new int[] {myAnswer[2], myAnswer[3]};
        return answer;
    }
}

public class Programmers178870 {
    public static void main(String[] args) {
        new Solution().solution(new int[]{1, 2, 3, 4, 5}, 7);
//        new Solution().solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5);
//        new Solution().solution(new int[]{2, 2, 2, 2, 2}, 6);
    }
}