//백준 단계별_03.01_2739_구구단
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.next());

        for(int i=1; i<=9; i++){
            System.out.print(String.format("%d * %d = %d", n, i, n*i));
            if(i != 9){
                System.out.print('\n');
            }
        }
    }
}