package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WaterPipeConstruction {
    private static final int MAX = 1<<24;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int l, c;
        int[] cap = new int[d + 1];
        cap[0] = MAX;

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            for (int j = d; j >= l; --j) {
                cap[j] = Math.max(cap[j], Math.min(c, cap[j - l]));
            }
        }
        System.out.println(cap[d]);


    }
}
