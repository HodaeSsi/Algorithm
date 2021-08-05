import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Main forFunc = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();

        System.out.println(forFunc.solution(readLine));
    }

    public static List<Long> numList = new LinkedList<>();
    public static List<Character> opeList = new LinkedList<>();

    public long solution(String expression) {

        //문자열 분리 : 1. 숫자, 2. 연산자
        String tempStr = "";
        for(int i = 0; i < expression.length(); i++) {
            char temp = expression.charAt(i);

            try {
                long tempNum = Long.parseLong(String.valueOf(temp));
                tempStr += String.valueOf(tempNum);

            } catch(Exception e) {
                opeList.add(temp);
                numList.add(Long.parseLong(tempStr));
                tempStr = "";
            }
        }
        numList.add(Long.parseLong(tempStr));

        //모든 경우의 수 계산
        long answer = Long.MIN_VALUE;
        answer = Math.max(answer, logic('*', '+', '-'));
        answer = Math.max(answer, logic('*', '-', '+'));
        answer = Math.max(answer, logic('+', '*', '-'));
        answer = Math.max(answer, logic('+', '-', '*'));
        answer = Math.max(answer, logic('-', '*', '+'));
        answer = Math.max(answer, logic('-', '+', '*'));

        return answer;
    }

    public long logic(char first, char second, char third) {
        List<Long> dupNumList = new LinkedList<>(numList);
        List<Character> dupOpeList = new LinkedList<>(opeList);

        for(int i = 0; i < dupOpeList.size(); i++) {
            char tempOpe = dupOpeList.get(i);
            if(tempOpe == first) { //탐색 시간 쌉손핸데??? O((1/2) * n^2)) 아니냐???
                dupNumList.set(i, cal(dupNumList.get(i), dupNumList.get(i+1), tempOpe));

                dupNumList.remove(i+1);
                dupOpeList.remove(i);
                i--;
            }
        }
        for(int i = 0; i < dupOpeList.size(); i++) {
            char tempOpe = dupOpeList.get(i);
            if(tempOpe == second) { //탐색 시간 쌉손핸데??? O((1/2) * n^2)) 아니냐???
                dupNumList.set(i, cal(dupNumList.get(i), dupNumList.get(i+1), tempOpe));

                dupNumList.remove(i+1);
                dupOpeList.remove(i);
                i--;
            }
        }
        for(int i = 0; i < dupOpeList.size(); i++) {
            char tempOpe = dupOpeList.get(i);
            if(tempOpe == third) { //탐색 시간 쌉손핸데??? O((1/2) * n^2)) 아니냐???
                dupNumList.set(i, cal(dupNumList.get(i), dupNumList.get(i+1), tempOpe));

                dupNumList.remove(i+1);
                dupOpeList.remove(i);
                i--;
            }
        }

        return Math.abs(dupNumList.get(dupNumList.size() -1));
    }

    public long cal(long num1, long num2, char ope) {
        if(ope == '*') {
            return num1 * num2;
        } else if(ope == '+') {
            return num1 + num2;
        } else if(ope == '-') {
            return num1 - num2;
        }
        return 0L; //이거 끝처리 이렇게 해야돼??? (여기오면 안된다는 느낌으로 error를 던지게 하던가???)
    }
}