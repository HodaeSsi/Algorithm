import java.util.*;

class Solution {
    private Set<Integer> operate(Set<Integer> left, Set<Integer> right) {
        Set<Integer> result = new HashSet<>();
        for (Integer lE: left) {
            for (Integer rE: right) {
                result.add(lE + rE);
                if (lE - rE >= 1) {
                    result.add(lE - rE);
                }
                result.add(lE * rE);
                if ((lE / rE) >= 1) {
                    result.add(lE / rE);
                }
            }
        }

        for (Integer rE: right) {
            for (Integer lE: left) {
                if (rE - lE >= 1) {
                    result.add(rE - lE);
                }
                if (rE / lE >= 1) {
                    result.add(rE / lE);
                }
            }
        }

        return result;
    }

    public int solution(int N, int number) {
        int answer = 0;
//        Set[] dp = new HashSet[8]; TODO: 제네릭 배열은 왜 못 만들까???("공변")
        List<Set<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>());
        Set<Integer> dp1 = new HashSet<>();
        dp1.add(N);
        dp.add(dp1);

        for (int i = 2; i < 9; i++) {
            Set<Integer> temp = new HashSet<>();
            for (int j = 1; j <= i/2; j++) {
                temp.addAll(operate(dp.get(j), dp.get(i - j))); // TODO: Set 자료형의 시간복잡도 잘 모르네???
            }
            // TODO: repeat 뭐냐 이건ㄷㄷ
            // TODO: 수의 자리수 구할때 log10도 쓸 수 있다는데, log10 시간복잡도가???
            temp.add(Integer.valueOf(String.valueOf(N).repeat(i)
            ));
            dp.add(temp);
        }

        for (int i = 1; i < 9; i++) {
            if (dp.get(i).contains(number)) {
                return i;
            }
        }

        return -1;
    }
}

public class Main {
    public static void main() {

    }
}