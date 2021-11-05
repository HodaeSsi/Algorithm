import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> timeTable = new ArrayList<>();

        String[] split;
        for(int i = 0; i < N; i++) {
            split = br.readLine().split(" ");
            timeTable.add(new int[] {
                Integer.parseInt(split[0]), Integer.parseInt(split[1])
            });
        }
        Collections.sort(timeTable, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1])
                    return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int pointer = 0;
        int answer = 0;
        for(int[] e : timeTable) {
            if(e[0] >= pointer) {
                pointer = e[1];
                answer++;
            }
        }

        System.out.println(answer);
    }
}