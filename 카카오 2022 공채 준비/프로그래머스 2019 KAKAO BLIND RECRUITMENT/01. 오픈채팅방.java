import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(",");
        for(int i = 0; i < split.length; i++) {
            split[i] = split[i].substring(1, split[i].length() -1);
        }

        String[] answer = solution(split);
        for(String e : answer) {
            System.out.println(e);
        }
    }

    public static Map<String, String> userInfo = new HashMap<>();

    public static String[] solution(String[] record) {
        String[] answer = {};
        List<String> tempStr = new ArrayList<>();

        for(String e : record) {
            String[] command = e.split(" ");
            if(command[0].equals("Enter")) {
                userInfo.put(command[1], command[2]);
            } else if (command[0].equals("Change")) {
                userInfo.put(command[1], command[2]);
            }
        }

        for(int i = 0; i < record.length; i++) {
            String[] command = record[i].split(" ");
            if(command[0].equals("Enter")) {
                tempStr.add(userInfo.get(command[1]) + "님이 들어왔습니다.");
            } else if(command[0].equals("Leave")) {
                tempStr.add(userInfo.get(command[1]) + "님이 나갔습니다.");
            }
        }

        answer = tempStr.toArray(new String[0]); //???
//        answer = tempStr.toArray(new String[tempStr.size()]);
        return answer;
    }
}