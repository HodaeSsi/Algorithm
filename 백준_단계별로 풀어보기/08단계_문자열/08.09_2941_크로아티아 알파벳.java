import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();

        int count = 0;
        for(int i = 0; i < readLine.length(); i++) {
            if(i < readLine.length() -1) {
                switch (readLine.charAt(i)) {
                    case 'c':
                        if(readLine.charAt(i+1) == '=' || readLine.charAt(i+1) == '-') {
                            i++;
                        }
                        count++;
                        break;
                    case 'd':
                        if(readLine.charAt(i+1) =='-') {
                            i++;
                        } else if(readLine.charAt(i+1) == 'z') {
                            if(!(i >= readLine.length() -2)) {
                                if(readLine.charAt(i+2) == '=') {
                                    i += 2;
                                }
                            }
                        }
                        count++;
                        break;
                    case 'l':
                    case 'n':
                        if(readLine.charAt(i+1) == 'j')
                            i++;
                        count++;
                        break;
                    case 's':
                    case 'z':
                        if(readLine.charAt(i+1) == '=')
                            i++;
                        count++;
                        break;
                    default:
                        count++;
                        break;
                }
            } else {
                count++;
            }
        }

        System.out.println(count);
    }
}