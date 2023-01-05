package com.hodaessi;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int maxArea(int[] height) {

        int[] sortedHeight = Arrays.stream(height).sorted().toArray();
        int currWidth = Integer.MIN_VALUE;

        for (int i = 0; i < sortedHeight.length; i++) {
            int left;
            int right;

            int j = 0;
            while (height[j] < sortedHeight[i]) {
                j++;
            }
            left = j;

            j = height.length - 1;
            while (height[j] < sortedHeight[i]) {
                j--;
            }
            right = j;

            int width = 0;
            if (left != right) {
                width = sortedHeight[i] * (right - left);
            }
            if (width > currWidth) {
                currWidth = width;
            }
        }

        return currWidth;
    }
}