import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(",");
        for(int i = 0; i < info.length; i++) {
            info[i] = info[i].substring(1, info[i].length() -1);
        }

        String[] query= br.readLine().split(",");
        for(int i = 0; i < query.length; i++) {
            query[i] = query[i].substring(1, query[i].length() -1);
        }

        for(int e: solution(info, query)) {
            System.out.println(e);
        }
    }

    static Map<String, List<Integer>> countMap = new HashMap<>();
    static List<List<Integer>> caseList;
    static List<Integer> searchTargetList;

    static int[] solution(String[] info, String[] query) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();

        //info마다 map에 값 추가
        for(String infoLine : info) {
            String[] split = infoLine.split(" ");
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 4; i++) {
                sb.append(split[i]);
            }
//            countMap.computeIfAbsent(sb.toString(), k -> new ArrayList<>());
            if(countMap.get(sb.toString()) == null)
                countMap.put(sb.toString(), new ArrayList<>());
            countMap.get(sb.toString()).add(Integer.parseInt(split[4]));

            for(int r = 1; r <= 4; r++) {
                //조합의 수 구하기
                caseList = new ArrayList<>();
                combination(4, r, 0, new ArrayList<>(), 0);
                for(List<Integer> caseNum : caseList) {
                    String[] copy = split.clone();
                    for(int loc : caseNum) {
                        copy[loc] = "-";
                    }
                    sb.setLength(0);
                    for(int j = 0; j < 4; j++) {
                        sb.append(copy[j]);
                    }
                    if(countMap.get(sb.toString()) == null)
                        countMap.put(sb.toString(), new ArrayList<>());
                    countMap.get(sb.toString()).add(Integer.parseInt(split[4]));
                }
            }
        }
        for(String key : countMap.keySet()) {
            Collections.sort(countMap.get(key));
        }

        //quert별로 이분탐색 진행
        for(String q : query) {
            String[] split = q.split(" ");
            String[] wantInfo = new String[5];
            for(int i = 0; i < 4; i++) {
                wantInfo[i] = split[i*2];
            }
            wantInfo[4] = split[7];
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 4; i++) {
                sb.append(wantInfo[i]);
            }

            if(countMap.get(sb.toString()) == null) {
                answerList.add(0);
                continue;
            }
            searchTargetList = countMap.get(sb.toString());
            int idx = binarySearch(0, searchTargetList.size() -1, Integer.parseInt(wantInfo[4]));
            answerList.add(searchTargetList.size() - idx);
        }

        answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++)
            answer[i] = answerList.get(i);
        return answer;
    }

    static void combination(int n, int r, int nowDepth, List<Integer> tempCaseList, int idx) {
        if(nowDepth == r) {
            caseList.add(tempCaseList);
            return;
        }
        for(int i = idx; i < 4; i++) {
            List<Integer> temp = new ArrayList<>(tempCaseList);
            temp.add(i);
            combination(n, r, nowDepth+1, temp, i+1);
        }
    }

    static int binarySearch(int start, int end, int target) {
        while(start<=end){
            int mid=(start+end)/2;
            if(searchTargetList.get(mid)<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }

        return start;
    }
}