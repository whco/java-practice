package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FourSquares {
    private static final int INF = 1<<30;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] minStep = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            minStep[i] = INF;
        }
        minStep[0] = 0;
        minStep[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                minStep[i] = Math.min(minStep[i - j * j] + 1, minStep[i]);
            }
        }
        System.out.println(minStep[n]);
    }
}
