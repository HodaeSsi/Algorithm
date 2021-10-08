import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] S = new int[N][N];
        for(int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(split[j]);
            }
        }

        //조합의 수
        Set<Integer> allMember = new HashSet<>();
        for(int i = 0; i < N; i++) {
            allMember.add(i);
        }
        combCase(S, N/2, 0, allMember, new HashSet<>());

        System.out.println(minDiff);
    }

    static int minDiff = Integer.MAX_VALUE;
    static void combCase(int[][] S, int r, int idx, Set<Integer> allMember, Set<Integer> teamOne) {
        if(teamOne.size() == r) {
            allMember.removeAll(teamOne);
            Set<Integer> teamTwo = new HashSet<>(allMember);
            int teamOneScore = calScore(S, teamOne);
            int teamTwoScore = calScore(S, teamTwo);

            minDiff = Math.min(Math.abs(teamOneScore - teamTwoScore), minDiff);

            allMember.addAll(teamOne);
            return;
        }

        for(int i = idx; i < S.length; i++) {
            HashSet<Integer> tempSet = new HashSet<>(teamOne);
            tempSet.add(i);
            combCase(S, r, i+1, allMember, tempSet);
        }
    }

    static int calScore(int[][] S, Set<Integer> teamSet) {
        int score = 0;

        Integer[] memberNums = teamSet.toArray(new Integer[0]);
        for(int i = 0; i < memberNums.length; i++) {
            int memI = memberNums[i];
            for(int j = i+1; j < memberNums.length; j++) {
                int memJ = memberNums[j];
                score += S[memI][memJ] + S[memJ][memI];
            }
        }

        return score;
    }
}