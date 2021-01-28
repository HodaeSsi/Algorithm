import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        int K = sc.nextInt();
        long sum = 0;

        for(int i = 0; i < K; i++){
            int temp = sc.nextInt();

            if(temp == 0){
                stack.pop();
            }else{
                stack.push(temp);
            }
        }

        for(int i : stack){
            sum += i;
        }

        System.out.println(sum);
    }
}