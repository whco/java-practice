package algorithm.baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Tree {
    private static int cnt = 0;
    private static int n;
    private static int[] parent;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int root = 0;
        n = scanner.nextInt();
        parent = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            parent[i] = scanner.nextInt();
            if(parent[i] == -1) root = i;
        }

        removeNode(scanner.nextInt());
        countLeaf(root);
        System.out.println(cnt);
    }

    public static void removeNode(int n) {
        parent[n] = -2;
        for (int i = 0; i < n; i++) {
            if (parent[i] == n) {
                removeNode(i);
            }
        }
    }

    public static void countLeaf(int r) {
        boolean isLeaf = true;
        visited[r] = true;
        if (parent[r] != -2) {
            for (int i = 0; i < n; i++) {
                if (parent[i] == r && !visited[i]) {
                    countLeaf(i);
                    isLeaf = false;
                }
            }
            if(isLeaf) ++cnt;
        }
    }
}