## [11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/description/)

### 내 풀이

```java
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
```

### 개선 후 풀이

*참고 : https://leetcode.com/problems/container-with-most-water/solutions/127443/container-with-most-water/

```java
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int width = 0;

        while (left < right) {

            int temp = Math.min(height[left], height[right]) * (right - left);
            if (temp > width) {
                width = temp;
            }

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return width;
    }
}
```