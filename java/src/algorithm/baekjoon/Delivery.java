package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Delivery {
    public static final int MAX = 200 * 10000;
    public static int[][] result;
    public static HashMap<Integer, HashMap<Integer, Integer>> dist = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        result = new int[n + 1][n + 1];


        int a, b, d;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            putIntoDist(a, b, d);
            putIntoDist(b, a, d);
        }

        System.out.println("working");

        //MST for each vertex, Prim's algorithm
        for (int i = 1; i <= n; i++) {
            System.out.println(i + " working");
            boolean[] visited = new boolean[n + 1];
            int[] parent = new int[n + 1];
            int[] minDist = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                minDist[j] = MAX;
            }

            minDist[i] = 0;
            int curVertex = i;
            int visitCnt = 0;

            while(visitCnt < n) {
                ++visitCnt;
                System.out.println(visitCnt + " visited");
                HashMap<Integer, Integer> curDistMap = dist.get(curVertex);
                for (Integer k : curDistMap.keySet()) {
                    int v = curDistMap.get(k);
                    if (minDist[curVertex] + v < minDist[k]) {
                        minDist[k] = minDist[curVertex] + v;
                        parent[k] = v;
                    }
                }
                int min = MAX;
                int minIdx = curVertex;
                for (int j = 1; j <= n; j++) {
                    if(minDist[j] < min){
                        min = minDist[j];
                        minIdx = j;
                    }
                }
                curVertex = minIdx;
            }
            System.out.println("here");
            for (int j = 1; j <= n; j++) {
                if(j == i) continue;
                int p = j;
                while(parent[p] != i)
                    p = parent[p];
                result[i][j] = p;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void putIntoDist(int a, int b, int d) {
        if(dist.containsKey(a))
            dist.get(a).put(b, d);
        else{
            HashMap<Integer, Integer> tmp = new HashMap<>();
            tmp.put(b, d);
            dist.put(a, tmp);
        }
    }
}
