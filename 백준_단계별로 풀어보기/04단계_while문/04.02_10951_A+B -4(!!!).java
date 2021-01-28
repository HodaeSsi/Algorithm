//백준4단계(while문)_04.02_10951_A+B -4
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws Exception {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        ArrayList<String> al = new ArrayList();
        do {
            String tmpStr = br.readLine();
            if(tmpStr == null)
                break;
            else
                al.add(tmpStr);
        } while (true);

        //System.out.print(al);
        for(String i: al){
            System.out.println(Integer.parseInt(i.split(" ")[0]) + Integer.parseInt(i.split(" ")[1]));
        }
    }
}

//!!!자바 입출력에 대해서!!!