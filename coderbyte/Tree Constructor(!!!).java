package com.hodaessi;

import java.util.*;
import java.io.*;

//TODO 1. queue - add / offer 차이
//TODO 2. list.stream().forEach() >> list.forEach() - 그럼 stream()은 뭐하는 애인가
//TODO 3. 유니온파인드 / 위상정렬
class Tree {

    Node root;

    public Tree(String adjacencyInfo) {

        String[] split = adjacencyInfo.substring(1, adjacencyInfo.length() - 1).split(",");
        Integer child = Integer.parseInt(split[0]);
        Integer parent = Integer.parseInt(split[1]);

        root = new Node(parent);
        root.children.add(new Node(child));
    }

    public Tree combine(Tree another) {

//        if (root.value.equals(another.root.value)) {
//            root.children.addAll(another.root.children);
//            another.root = root;
//            return this;
//        }

        Node child = another.bfs(root.value);
        if (child != null) {
            child.children.addAll(root.children);
            return another;
        }

        child = bfs(another.root.value);
        if (child != null) {
            child.children.add(another.root);
            another.root = root;
            return this;
        }

        return null;
    }

    private Node bfs(int target) {

        Queue<Node> q = new LinkedList<>();

        q.offer(root);
        while (!q.isEmpty()) {
            Node present = q.poll();

            if (present.value == target) {
                return present;
            }

            present.children.forEach(q::offer);
        }

        return null;
    }

    public boolean validBinary() {

        Queue<Node> q = new LinkedList<>();

        q.offer(root);
        while (!q.isEmpty()) {
            Node present = q.poll();

            if (present.children.size() >= 3) {
                return false;
            }

            present.children.forEach(q::offer);
        }

        return true;
    }
}

class Node {

    Integer value;
    List<Node> children = new ArrayList<>();

    public Node(Integer value) {
        this.value = value;
    }
}

class Main {

    public static String TreeConstructor(String[] strArr) {
        // code goes here
        List<Tree> treeList = new LinkedList<>();

        Arrays.stream(strArr).forEach(e -> treeList.add(new Tree(e)));

        for (int i = 0; i < treeList.size(); i++) {
            for (int j = 0; i < treeList.size() && j < treeList.size(); j++) {
                if (i == j) {
                    continue;
                }
                Tree combineResult = treeList.get(i).combine(treeList.get(j));
                if (combineResult == treeList.get(i)) {
                    treeList.remove(j);
                    j--;
                } else if (combineResult == treeList.get(j)) {
                    treeList.remove(i);
                    j--;
                }
            }
        }

        if (treeList.size() > 1) {
            return "false";
        }
        if (!treeList.get(0).validBinary()) {
            return "false";
        }

        return "true";
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(TreeConstructor(new String[] {"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"}));
    }

}