import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(", ");
        String[] orders = new String[split.length];
        for(int i = 0; i < orders.length; i++) {
            orders[i] = split[i].substring(1, split[i].length() -1);
        }

        split = br.readLine().split(",");
        int[] course = new int[split.length];
        for(int i = 0; i < course.length; i++) {
            course[i] = Integer.parseInt(split[i]);
        }

        String[] answers = solution(orders, course);
        for(String answer : answers) {
            System.out.println(answer);
        }
    }

    static Map<String, Integer> combinations;
    static int maxValueInCombination;
    static String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        //1. 조합의 수 구하기
        //2. 경우의 수 별로 카운트
        for(int i = 0; i < orders.length; i++) {
            char[] order = orders[i].toCharArray();
            Arrays.sort(order);
            orders[i] = String.valueOf(order);
        }

        PriorityQueue<String> result = new PriorityQueue<>();
        for(int r : course) {
            combinations = new HashMap<>();
            maxValueInCombination = 0;
            for(String order : orders) {
                makeCombinationAndCount(order, r, "", 0);
            }
            for(String combination : combinations.keySet()) {
                if(maxValueInCombination >= 2 && combinations.get(combination) == maxValueInCombination) {
                    result.offer(combination);
                }
            }
        }

        answer = new String[result.size()];
        int k = 0;
        while(!result.isEmpty()) {
            answer[k++] = result.poll();
        }

        return answer;
    }

    static void makeCombinationAndCount(String n, int r, String string, int idx) {
        if(string.length() == r) {
            combinations.put(string, combinations.getOrDefault(string, 0) +1);
            maxValueInCombination = Math.max(maxValueInCombination, combinations.get(string));
            return;
        }
        for(int i = idx; i < n.length(); i++) {
            makeCombinationAndCount(n, r, string.concat(String.valueOf(n.charAt(i))), i +1);
        }
    }
}