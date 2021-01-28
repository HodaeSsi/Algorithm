//백준 단계별_1.11_2588_곱셈
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int a = Integer.parseInt(sc.next());
        int b = Integer.parseInt(sc.next());

        int third = b / 100;
        int second = (b - third * 100) / 10;
        int first = b - third * 100 - second * 10;

        int answer1 = a * first;
        int answer2 = a * second;
        int answer3 = a * third;
        int asnwer4 = a * b;

        System.out.print(String.valueOf(answer1) + " " +
                String.valueOf(answer2) + " " +
                String.valueOf(answer3) + " " +
                String.valueOf(asnwer4));
    }
}