import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static Stack<Integer> pos = new Stack<Integer>();
    public static Stack<Integer> h = new Stack<Integer>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String[] line = br.readLine().split(" ");
            if(line[0].equals("0"))
                break;

            int[] block = new int[line.length-1];
            for(int i = 1 ; i < line.length; i++) {
                block[i-1] = Integer.parseInt(line[i]);
            }

            Long large = 0L;

            for(int i = 0; i < block.length; i++) {
                if(pos.isEmpty()) {
                    if(block[i] != 0) {
                        pos.push(i);
                        h.push(block[i]);
                    }
                } else {
                    if(block[i] > h.peek()) {
                        pos.push(i);
                        h.push(block[i]);
                    } else if (block[i] < h.peek()) {
                        int minPos = Integer.MAX_VALUE;
                        while(block[i] < h.peek()) {
                            int tempPos = pos.pop();
                            minPos = Math.min(tempPos, minPos);
                            int tempH = h.pop();
                            long tempSize = (i - tempPos) * (long)tempH;
                            large = Math.max(tempSize, large);

                            if(pos.isEmpty())
                                break;
                        }
                        if(block[i] != 0) {
                            pos.push(minPos);
                            h.push(block[i]);
                        }
                    }
                }
            }
            while(!pos.isEmpty()) {
                int tempPos = pos.pop();
                int tempH = h.pop();
                long tempSize = (block.length - tempPos) * (long)tempH;
                large = Math.max(tempSize, large);
            }

            System.out.println(large);
            pos.clear();
            h.clear();
        }
    }
}