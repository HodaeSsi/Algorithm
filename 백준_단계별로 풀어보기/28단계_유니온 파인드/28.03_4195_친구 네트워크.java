import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

class Node {
    String myName;
    String parentName;
    int setInfo;
    Node(String name) {
        this.myName = name;
        this.parentName = name;
        this.setInfo = -1;
    }
}

public class Main {
    public static HashMap<String, Node> parent = new HashMap<String, Node>();

    public static String find(String child) {
        if(parent.get(child).parentName.equals(parent.get(child).myName)) {
            return child;
        } else {
            String p = find(parent.get(child).parentName);
            parent.get(child).parentName = p;
            return p;
        }
    }

    public static void union(String name1, String name2) {
        String p1 = find(name1);
        String p2 = find(name2);
        if(p1.equals(p2))
            return;
        if(parent.get(p1).setInfo < parent.get(p2).setInfo) {
            parent.get(p2).parentName = p1;
            parent.get(p1).setInfo += parent.get(p2).setInfo;
        } else {
            parent.get(p1).parentName = p2;
            parent.get(p2).setInfo += parent.get(p1).setInfo;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int F = Integer.parseInt(br.readLine());
            for(int f = 0; f < F; f++) {
                String[] readLine = br.readLine().split(" ");
                if(!parent.containsKey(readLine[0])) {
                    Node tmp = new Node(readLine[0]);
                    parent.put(readLine[0], tmp);
                }
                if(!parent.containsKey(readLine[1])) {
                    Node tmp = new Node(readLine[1]);
                    parent.put(readLine[1], tmp);
                }

                union(readLine[0], readLine[1]);

                sb.append((parent.get(find(readLine[0])).setInfo * -1) + "\n");
            }
            parent.clear();
        }
        System.out.print(sb);
    }
}