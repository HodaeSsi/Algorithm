import java.util.Arrays;

class Solution {
    private int operate(int a, String op, int b) {
        if (op.equals("+")) {
            return a + b;
        } else if (op.equals("-")) {
            return a - b;
        }
        throw new IllegalArgumentException();
    }

    public int solution(String arr[]) {
        int answer = -1;

        int[][] dp_max = new int[arr.length/2 + 1][arr.length/2 + 1];
        int[][] dp_min = new int[arr.length/2 + 1][arr.length/2 + 1];

        //init
        int i = 0;
        int j = 0;
        while (j < dp_max[0].length) {
            dp_max[i][j] = Integer.parseInt(arr[j * 2]);
            dp_min[i][j] = Integer.parseInt(arr[j * 2]);
            i++;
            j++;
        }

        i = 0;
        j = 1;
        while (j < dp_max[0].length) {
            dp_max[i][j] = operate(dp_max[i][j-1], arr[j * 2 - 1], dp_max[i+1][j]);
            dp_min[i][j] = operate(dp_min[i][j-1], arr[j * 2 - 1], dp_min[i+1][j]);
            i++;
            j++;
        }

        i = 0;
        j = 2;
        while (j < dp_max[0].length) {
            int _i = i;
            int _j = j;
            while (_j < dp_max[0].length) {
//                dp_max[_i][_j] = Math.max(
//                        operate(dp_max[_i][_j - 1], arr[_j * 2 - 1], Integer.parseInt(arr[_j * 2])),
//                        operate(Integer.parseInt(arr[2 * _i]), arr[2 * _i + 1], dp_max[_i+1][_j])
//                );
                int temp_max = Integer.MIN_VALUE;
                int temp_min = Integer.MAX_VALUE;

                for (int k = _i; k < _j; k++) {
                    if (arr[2*k + 1].equals("+")) {
                        temp_max = Math.max(temp_max, dp_max[_i][k] + dp_max[k+1][_j]);
                        temp_min = Math.min(temp_min, dp_min[_i][k] + dp_min[k+1][_j]);
                    } else if (arr[2*k + 1].equals("-")) {
                        temp_max = Math.max(temp_max, dp_max[_i][k] - dp_min[k+1][_j]);
                        temp_min = Math.min(temp_min, dp_min[_i][k] - dp_max[k+1][_j]);
                    }
                }

                dp_max[_i][_j] = temp_max;
                dp_min[_i][_j] = temp_min;

                _i++;
                _j++;
            }
            j++;
        }

        answer = dp_max[0][dp_max[0].length - 1];
        return answer;
    }
}