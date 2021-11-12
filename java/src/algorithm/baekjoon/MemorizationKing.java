package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class MemorizationKing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t, n, m;
        t = Integer.parseInt(st.nextToken());
        StringBuffer sb = new StringBuffer();
        while(t-- != 0) {
            HashSet<Integer> memo1 = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                memo1.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int b = memo1.contains(Integer.parseInt(st.nextToken())) ? 1 : 0;
                sb.append(b + "\n");
            }


        }
        System.out.println(sb);
    }
}
