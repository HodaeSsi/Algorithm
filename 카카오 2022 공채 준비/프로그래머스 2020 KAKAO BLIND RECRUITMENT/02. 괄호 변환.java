import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String p) {
        String answer = "";
        answer = routine(p);

        return answer;
    }

    static String routine(String w) {
        //1.
        if(w.equals(""))
            return "";

        //2.
        Map<Character, Integer> count = new HashMap<>();
        char firstChar = w.charAt(0);
        char notFirst = ')';
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == firstChar) {
                count.put(firstChar, count.getOrDefault(firstChar, 0) +1);
            } else if (w.charAt(i) != firstChar) {
                notFirst = w.charAt(i);
                count.put(notFirst, count.getOrDefault(notFirst, 0) +1);
                if(count.get(firstChar).equals(count.get(notFirst)))
                    break;
            }
        }
        String u = w.substring(0, count.get('(') + count.get(')'));
        String v = w.substring(u.length());

        System.out.println(u);
        System.out.println(v);

        //3.
        boolean isComplete = false;
        int cnt = 0;
        if (u.charAt(0) == '(')
            for (int i = 0; i < u.length(); i++) {
                if(u.charAt(i) == '(')
                    cnt++;
                else if(u.charAt(i) == ')')
                    cnt--;
            }
        if (u.charAt(0) == '(' && cnt == 0)
            isComplete = true;

        //3-1
        if(isComplete)
            return u + routine(v);

        //4
        String tmp = "(" + routine(v) + ")";
        StringBuilder reverseU = new StringBuilder();
        for(int i = 1; i < u.length() -1; i++) {
            if(u.charAt(i) == '(')
                reverseU.append(")");
            else if (u.charAt(i) == ')')
                reverseU.append("(");
        }

        return tmp + reverseU;
    }
}