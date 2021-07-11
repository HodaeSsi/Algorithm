import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> n = new ArrayList<>();

        String[] readLine = br.readLine().split(" ");

        for(int i = 0; i < readLine.length; i++) {
            n.add(Integer.parseInt(readLine[i]));
        }
        Collections.sort(n);

        int s = 0;
        int e = readLine.length -1;
        int[] absMinInfo = new int[3]; //값, s, e
        absMinInfo[0] = Integer.MAX_VALUE;
        absMinInfo[1] = 0; //= s 하면 값을 넘길까 주소값을 넘길까 ???
        absMinInfo[2] = readLine.length -1;

        while(s < e) {
            //가리키는 곳의 합
            int temp = n.get(s) + n.get(e);

            //abs값 비교 & 최소값 갱신되면 포인터 정보 저장
            boolean isNewMin = (Math.abs(temp) < absMinInfo[0]);
            if(isNewMin) {
                absMinInfo[0] = Math.abs(temp);
                absMinInfo[1] = s;
                absMinInfo[2] = e;
            }

            //abs적용 전 값의 부호를 보고 이동할 포인터 결과 & 이동
            if(temp > 0)
                e--;
            else if(temp < 0)
                s++;
            else
                break;
        }

        System.out.println(n.get(absMinInfo[1]) + " " + n.get(absMinInfo[2]));
    }
}