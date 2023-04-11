package com.hodaessi;

import java.util.HashMap;
import java.util.Map;

//TODO 1. 남의 풀이
//TODO 2. 함수형 프로그래밍(람다, 스트림)
//TODO 3. 이게 알고리즘 문제가 아니라, 요구사항 "구현"이라면?(ex. 성격유형 종류가 추가됐다거나, ...)
class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> personalityScoreMap = new HashMap<>();
        personalityScoreMap.put("R", 0);
        personalityScoreMap.put("T", 0);
        personalityScoreMap.put("C", 0);
        personalityScoreMap.put("F", 0);
        personalityScoreMap.put("J", 0);
        personalityScoreMap.put("M", 0);
        personalityScoreMap.put("A", 0);
        personalityScoreMap.put("N", 0);

        //RT, CF, JM, AN
        for (int i = 0; i < survey.length; i++) {
            String[] personalityType = survey[i].split("");

            if (choices[i] < 4) {
                //TODO: put말고 수정은 없냐;;?
                personalityScoreMap.put(personalityType[0], personalityScoreMap.get(personalityType[0]) + (4 - choices[i]));
            } else if (choices[i] > 4) {
                personalityScoreMap.put(personalityType[1], personalityScoreMap.get(personalityType[1]) + (choices[i] - 4));
            }
        }

        if (personalityScoreMap.get("R") >= personalityScoreMap.get("T")) {
            sb.append("R");
        } else {
            sb.append("T");
        }
        if (personalityScoreMap.get("C") >= personalityScoreMap.get("F")) {
            sb.append("C");
        } else {
            sb.append("F");
        }
        if (personalityScoreMap.get("J") >= personalityScoreMap.get("M")) {
            sb.append("J");
        } else {
            sb.append("M");
        }
        if (personalityScoreMap.get("A") >= personalityScoreMap.get("N")) {
            sb.append("A");
        } else {
            sb.append("N");
        }

        return sb.toString();
    }
}