import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = new Main().solution(br.readLine());

        System.out.println(answer);
    }

    public int solution(String s) {
        int answer = 0;

        String[] word = {"zero", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine"};
        String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for(int i = 0; i < word.length; i++) {
            s = s.replaceAll(word[i], num[i]);
        }

        answer = Integer.parseInt(s);
        return answer;
    }
}