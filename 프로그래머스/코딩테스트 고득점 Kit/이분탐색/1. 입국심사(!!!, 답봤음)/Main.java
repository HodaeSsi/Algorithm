import java.util.*;

class Solution {
    public long sumAllProduction(int[] times, long t) {
        long sum = 0;
        for (int time: times) {
            sum += t / time;
        }
        return sum;
    }

    public long solution(int n, int[] times) {
        long answer = 0;

        //lowerBound
        long start = 0L;
        long end = 100000000000001L;
        long target = n;
        long peek = -1L;

        while (start < end) {
            peek = (start + end) / 2;
            if (sumAllProduction(times, peek) < target) {
                start = peek + 1;
            } else {
                end = peek;
            }
        }

        answer = start;

        return answer;
    }
}