import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Main forFunc = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] gems = br.readLine().split(", ");
        for(int i = 0; i < gems.length; i++) {
            gems[i] = gems[i].substring(1, gems[i].length()-1);
        }

        int[] answer = forFunc.solution(gems);

        System.out.println(answer[0] + " " + answer[1]);
    }

    public static Set<String> set = new HashSet<>();
    public static Map<String, Integer> map = new HashMap<>();
    public static Queue<String> q = new LinkedList<>();

    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        for(String gem : gems) {
            set.add(gem); //뭐래 람다식??? Iteration???
        }

        int start = 0;
        int shortest = Integer.MAX_VALUE;
        for(int i = 0; i < gems.length; i++) {

            //도착
            map.put(gems[i], map.getOrDefault(gems[i], 0) +1);
            q.add(gems[i]);

            //최소화 : 출발지점 이동
            while(true) {
                if(map.get(q.peek()) > 1) {

                    map.put(q.peek(), map.get(q.peek()) -1);
                    q.poll();
                    start++;
                } else {
                    break;
                }
            }

            //결과 확인 : 시작, 끝점 갱신
            if(map.size() == set.size() && i - start < shortest) {
                answer[0] = start;
                answer[1] = i;
                shortest = i - start;
            }
        }

        answer[0]++;
        answer[1]++;
        return answer;
    }
}