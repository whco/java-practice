package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SnakeLadderGame {

    static int[] minStep = new int[101];
    static boolean[] visited = new boolean[101];

    static HashMap<Integer, Integer> ladderAndSnake = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());



        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            ladderAndSnake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }


        Queue<Integer> q = new LinkedList<>();

        int max = 100;
        q.add(1);
        visited[1] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            for (int i = 1; i <= 6; i++) {
                checkAndSet(cur, i, q);
            }
            if(minStep[100] != 0)
            {
                System.out.println(minStep[100]);
                break;
            };
        }
    }

    public static void checkAndSet(int cur, int i, Queue<Integer> q) {
        int dst = checkLadderAndSnake(cur + i);
        if(dst > 100) return;
        if(!visited[dst]) {
            minStep[dst] = minStep[cur] + 1;
            visited[dst] = true;
            q.add(dst);
        }
    }

    public static int checkLadderAndSnake(int i){
        if(ladderAndSnake.containsKey(i)) return ladderAndSnake.get(i);
        return i;
    }
}
