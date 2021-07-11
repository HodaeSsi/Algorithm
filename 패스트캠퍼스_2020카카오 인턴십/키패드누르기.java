import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main main = new Main();

        String[] readLine = br.readLine().split(", ");
        int[] number = new int[readLine.length];
        for(int i = 0; i < readLine.length; i++) {
            number[i] = Integer.parseInt(readLine[i]);
        }

        System.out.println(
            main.solution(
                number,
                br.readLine()
            )
        );
    }

    public static int[] l_thumb = {3, 0};
    public static int[] r_thumb = {3, 2};

    public static String _hand;

    public String solution(int[] numbers, String hand) {
        _hand = hand;
        String answer="";

        for(int e: numbers) {
            answer += move(e);
        }

        return answer;
    }

    public String move(int targetNum) {
        //움직일 손결정
        if (targetNum == 1 || targetNum == 4 || targetNum == 7) {
            //좌표 변환 및 손 이동
            moveHand("left", casting_location("" + targetNum));

            return "L";
        }

        if (targetNum == 3 || targetNum == 6 || targetNum == 9) {
            moveHand("right", casting_location("" + targetNum));

            return "R";
        }

        //거리 계산
        int[] targetLoc = casting_location("" + targetNum);
        int leftDistance = Math.abs(l_thumb[0] - targetLoc[0]) + Math.abs(l_thumb[1] - targetLoc[1]);
        int rightDistance = Math.abs(r_thumb[0] - targetLoc[0]) + Math.abs(r_thumb[1] - targetLoc[1]);
        String chosenHand = "error";

        if(leftDistance < rightDistance) {
            moveHand("left", targetLoc);
            chosenHand = "L";
        }
        if(rightDistance < leftDistance) {
            moveHand("right", targetLoc);
            chosenHand = "R";
        }
        if(rightDistance == leftDistance) {
            if(_hand.equals("left")) {
                moveHand("left", targetLoc);
                chosenHand = "L";
            }
            if(_hand.equals("right")) {
                moveHand("right", targetLoc);
                chosenHand = "R";
            }
        }

        return chosenHand;
    }

    public int[] casting_location(String num) {
        int[] tmp = new int[2];

        switch(num) {
            case "1":
                tmp[0] = 0;
                tmp[1] = 0;
                break;
            case "2":
                tmp[0] = 0;
                tmp[1] = 1;
                break;
            case "3":
                tmp[0] = 0;
                tmp[1] = 2;
                break;
            case "4":
                tmp[0] = 1;
                tmp[1] = 0;
                break;
            case "5":
                tmp[0] = 1;
                tmp[1] = 1;
                break;
            case "6":
                tmp[0] = 1;
                tmp[1] = 2;
                break;
            case "7":
                tmp[0] = 2;
                tmp[1] = 0;
                break;
            case "8":
                tmp[0] = 2;
                tmp[1] = 1;
                break;
            case "9":
                tmp[0] = 2;
                tmp[1] = 2;
                break;
            case "*":
                tmp[0] = 3;
                tmp[1] = 0;
                break;
            case "0":
                tmp[0] = 3;
                tmp[1] = 1;
                break;
            case "#":
                tmp[0] = 3;
                tmp[1] = 2;
                break;
        }

        return tmp;
    }

    public void moveHand(String hand, int[] des) {
        if(hand == "left") {
            l_thumb[0] = des[0];
            l_thumb[1] = des[1];
        }
        if(hand == "right") {
            r_thumb[0] = des[0];
            r_thumb[1] = des[1];
        }
    }
}