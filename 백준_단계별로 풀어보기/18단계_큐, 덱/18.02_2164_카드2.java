import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //Queue<Integer> que = new Queue<Integer>(); 이거 왜 안됨 스택은 그냥 되던데
        Queue<Integer> que = new LinkedList<>();
        //!!! 이거 자바 구조좀 알아보자 !!!

        int N = sc.nextInt();
        for(int i = 1; i <= N; i++){
            que.add(i);
        }

        while(que.size() != 1){
            que.poll();
            que.add(que.poll());
        }

        System.out.print(que.poll());
    }
}