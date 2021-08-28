import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        if(s.length() == 1) { //아래 알고리즘이 s.len == 1의 경우를 포함하지 못함
            return 1;
        }
        //압축문자 크기 : 1 ~ s.len/2
        for(int i = 1; i <= s.length()/2; i++) {
            int now = 0;
            int step = i;
            List<Integer> counts = new ArrayList<>();
            List<String> words = new ArrayList<>();
            //now가 바뀔때마다 counts - 1, words에 해당 문자 추가
            counts.add(1);
            words.add(s.substring(now, now +i));
            //문자열 순회
            while(now <= s.length() - i) {
                //다음 문자 조회 : 같다
                if(s.substring(now, now +i).equals(s.substring(step, step +i))) {
                    //압축 표기
                    counts.set(counts.size() -1, counts.get(counts.size() -1) +1);

                //다음 문자 조회 : 다르다
                } else {
                    //now를 현재스텝위치로
                    now = step;
                    counts.add(1);
                    words.add(s.substring(now, now +i));
                }

                //스텝 진행
                step += i;
                if(step +i -1 >= s.length()) {
                    //남은 문자열 있는지 확인
                    if(!(step >= s.length())) {
                        counts.add(1);
                        words.add(s.substring(step));
                    }
                    break;
                }
            }

            //정답 문자열 생성
            String answerString = "";
            for(int j = 0; j < counts.size(); j++) {
                if(counts.get(j) != 1) {
                    answerString += "" + counts.get(j);
                }
                answerString += "" + words.get(j);
            }

            //문자열 길이 비교
            answer = Math.min(answer, answerString.length());
        }
        return answer;
    }
}