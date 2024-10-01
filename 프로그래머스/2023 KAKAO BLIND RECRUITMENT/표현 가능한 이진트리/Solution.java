import java.util.*;

class Main {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution().solution(new long[]{7, 42, 5})));
        System.out.println(Arrays.toString(new Solution().solution(new long[]{5})));
    }
}

class Solution {
    private boolean binarySearch(List<Integer> binaryList, int startIdx, int endIdx) {
        int middle = (startIdx + endIdx) / 2;
        int nextLeft = (startIdx + middle) / 2;
        int nextRight = (middle + endIdx) / 2;

        if (endIdx - startIdx == 1) {
            return true;
        }
        if (binaryList.get(middle) == 0 && (binaryList.get(nextLeft) == 1 || binaryList.get(nextRight) == 1)) {
            return false;
        }
        return binarySearch(binaryList, startIdx, middle) && binarySearch(binaryList, middle + 1, endIdx);
    }

    private int getTreeHeight(int binaryLength) {
        int height = 1;
        while (binaryLength > Math.pow(2, height) - 1) {
            height++;
        }
        return height;
    }

    private Deque<Integer> longToBinary(long number) {
        Deque<Integer> binary = new ArrayDeque<>();

        while (number > 0) {
            binary.addFirst((int) (number % 2));
            number /= 2;
        }

        return binary;
    }

    private int isBinary(long number) {
        if (number == 1) {
            return 1;
        }

        // number -> 2진수 >> O(number 자리수)
        Deque<Integer> binaryDeque = this.longToBinary(number);

        // 2 ^ 층수 - 1 개수가 될때까지 앞에 0 추가 >> 최대 6층
        int height = this.getTreeHeight(binaryDeque.size());
        while (binaryDeque.size() < Math.pow(2, height) - 1) {
            binaryDeque.addFirst(0);
        }

        // Deque -> Binary Tree
        // 트리 순회 하며 루트가 0이면 0 >> 최대 약 O(log_2(50))
        List<Integer> binaryList = new ArrayList<>(binaryDeque);
        if (this.binarySearch(binaryList, 0, binaryList.size())) {
            return 1;
        } else {
            return 0;
        }
    }

    public int[] solution(long[] numbers) {
        List<Integer> answerList = new ArrayList<>();

        for (long number : numbers) {
            answerList.add(this.isBinary(number));
        }

        return answerList.stream().mapToInt(i -> i).toArray();
    }
}