import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        String[] suffixArr = new String[S.length()];
        for(int i = 0; i < S.length(); i++) {
            suffixArr[i] = S.substring(i);
        }

        Arrays.sort(suffixArr);
        for(int i = 0; i < suffixArr.length; i++) {
            System.out.println(suffixArr[i]);
        }
    }
}