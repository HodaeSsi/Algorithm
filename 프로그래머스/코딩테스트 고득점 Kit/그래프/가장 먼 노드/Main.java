// https://school.programmers.co.kr/learn/courses/30/lessons/49189

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        // 인접 리스트 & visit & toDistance 구성
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        int[] toDistance = new int[n+1]; // CHECK: 무조건 래퍼 클래스로?(프리미티브 불편;;) >> 대신 기본값이 0이 아니라 null이네 ㄷㄷ(초기화 필요)
        boolean[] visitedNode = new boolean[n+1];
        
        for (int[] line : edge) {
            adjacencyList.get(line[0]).add(line[1]);
            adjacencyList.get(line[1]).add(line[0]);
        }
        
        // BFS를 통한 1~x 거리(간선 개수) 계산
        Queue<Integer> q = new LinkedList<>();

        toDistance[1] = 0;
        visitedNode[1] = true;
        q.offer(1);

        while(!q.isEmpty()) {
            Integer nowNode = q.poll();

            for (Integer adjNode : adjacencyList.get(nowNode)) {
                if (!visitedNode[adjNode]) {
                    toDistance[adjNode] = toDistance[nowNode] + 1;
                    visitedNode[adjNode] = true;
                    q.offer(adjNode);
                }
            }
        }
        
        // sort 및 정답 추출
        Arrays.sort(toDistance);

        int temp = toDistance[toDistance.length - 1];
        for (int i = toDistance.length - 1; i >= 0; i--) {
            if (toDistance[i] == temp) {
                answer += 1;
            } else {
                break;
            }
        }
        
        return answer;
    }
}

public class Main {
    public static void main() {

    }
}