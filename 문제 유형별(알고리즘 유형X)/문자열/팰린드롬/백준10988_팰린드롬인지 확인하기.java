import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();

        int s = 0;
        int e = text.length() -1;

        int answer = 1;

        while(s <= e) {
            if(text.charAt(s) != text.charAt(e)) {
                answer = 0;
                break;
            }

            s++;
            e--;
        }

        System.out.println(answer);
    }
}