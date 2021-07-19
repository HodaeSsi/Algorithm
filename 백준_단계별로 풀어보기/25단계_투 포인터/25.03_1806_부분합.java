import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] readLine = br.readLine().split(" ");

        int N = Integer.parseInt(readLine[0]);
        int S = Integer.parseInt(readLine[1]);

        List<Integer> list = new ArrayList<>();
        readLine = br.readLine().split(" ");
        for(int i = 0; i < N; i++)
            list.add(Integer.parseInt(readLine[i]));

        int s = 0;
        int e = 0;
        int tempSum = list.get(0);
        int[] flag = {-1,-1, Integer.MAX_VALUE};
        while(true) {
            //도착계산 및 결과저장
            if(tempSum >= S && e-s < flag[2]) {
                flag[0] = s;
                flag[1] = e;
                flag[2] = e-s;
            }

            //출발
            if(s == e) {
                e++;
                if(e >= readLine.length)
                    break;
                tempSum += list.get(e);
            } else {
                if(tempSum < S) {
                    e++;
                    if(e >= readLine.length)
                        break;
                    tempSum += list.get(e);
                } else {
                    tempSum -= list.get(s);
                    s++;
                }
            }
        }

        //결과
        if(flag[0] == -1 && flag[1] == -1)
            System.out.println(0);
        else
            System.out.println(flag[2] + 1);
    }
}