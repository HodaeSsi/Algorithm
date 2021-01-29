import java.util.Stack;
import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Stack<Character> stack = new Stack<Character>();
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        String[] tc = new String[T];

        for(int n = 0; n < T; n++){
            //스택 진행
            //1. '(' > push
            //2. ')' > pop
            //2.1. pop할게 없다? >> NO
            tc[n] = sc.next();
            boolean nextTC = false;
            for(int i = 0; i < tc[n].length(); i++){
                char temp = tc[n].charAt(i);
                if(temp == '('){
                    stack.push('(');
                }else{
                    try{
                        if(stack.pop() == '('){

                        }
                    }catch(Exception e){
                        System.out.println("NO");
                        nextTC = true;
                        break;
                    }
                }
            }

            //스택 진행 끝
            //스택 남은거 있다? >> NO
            //남은게 없다? >> YES
            if(nextTC == false){
                try{
                    if(stack.pop() == '('){
                        System.out.println("NO");
                    }
                }catch(Exception e){
                    System.out.println("YES");
                }
            }
            stack.clear();
        }
    }
}