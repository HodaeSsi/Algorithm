import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList<Integer>();
        ArrayList<Integer> answer = new ArrayList<Integer>();

        int N = sc.nextInt();
        int K = sc.nextInt();
        //파이썬은 {N, K} = 입력.split() 할수있는데 ㅠㅠ

        int idx = 0;
        for(int i = 1; i <= N; i++){
            al.add(i);
        }
        while(al.size() != 0 ){
            for(int i = 0; i < K-1; i++){
                if(idx >= al.size()-1){
                    idx = 0;
                    continue;
                }else{
                    idx++;
                }
            }
            answer.add(al.remove(idx));
            if(idx >= al.size()){
                idx = 0;
            }
        }

        //System.out.println(answer);
        System.out.print('<');
        for(int i = 0; i < answer.size()-1; i++){
            System.out.print(answer.get(i));
            System.out.print(", ");
        }
        System.out.print(answer.get(answer.size()-1));
        System.out.print('>');
        //!!! 으엑 출력 개복잡해 !!!
        /*
        System.out.println(N);
        System.out.println(K);
        //파이썬이나 C는 print(N, K)출력할 수 있는데???
         */
    }
}