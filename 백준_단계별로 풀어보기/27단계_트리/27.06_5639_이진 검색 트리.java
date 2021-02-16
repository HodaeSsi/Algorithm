import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node {
    Node left;
    Node right;
    int val;

    public Node(int v) {
        this.val = v;
    }
}

public class Main {
    public static void insertNode(Node node, int N) {
        if(N < node.val) {
            if(node.left == null) {
                Node tmp = new Node(N);
                node.left = tmp;
            } else {
                insertNode(node.left, N);
            }
        } else if (node.val < N) {
            if(node.right == null) {
                Node tmp = new Node(N);
                node.right = tmp;
            } else {
                insertNode(node.right, N);
            }
        }
    }

    public static void postOrder(Node node) {
        if(node.left != null)
            postOrder(node.left);
        if(node.right != null)
            postOrder(node.right);

        System.out.println(node.val);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read = br.readLine();
        Node root = new Node(Integer.parseInt(read));
        while((read = br.readLine()) != null) {
            insertNode(root, Integer.parseInt(read));
        }
        postOrder(root);
    }
}