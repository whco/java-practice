package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MakingOne {
    private static final int INF = 1<<30;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());

        int[] step = new int[x + 1];
        step[0] = INF;
        for (int i = 2; i <= x; i++) {
            int a = 0, b = 0, c = i - 1;
            if(i % 3 == 0 && i / 3 >= 1) a = i / 3;
            if(i % 2 == 0 && i / 2 >= 1) b = i / 2;
            step[i] = Math.min(step[a], Math.min(step[b], step[c])) + 1;
        }
        System.out.println(step[x]);

    }
}
