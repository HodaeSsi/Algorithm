//백준 단계별_03.11_10871_X보다 작은 수
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> NX = new ArrayList();
        ArrayList<Integer> n = new ArrayList();
        ArrayList<Integer> answer = new ArrayList();

        NX.add(Integer.parseInt(sc.next()));
        NX.add(Integer.parseInt(sc.next()));

        for(int i = 0; i < NX.get(0); i++){
            n.add(Integer.parseInt(sc.next()));
            if(n.get(i) < NX.get(1)){
                answer.add(n.get(i));
            }
        }

        for(int output: answer){
            System.out.print(output + " ");
        }
    }
}