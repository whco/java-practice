package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RemoteController {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        boolean[] isBroken = new boolean[10];
        if(m != 0) {
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                isBroken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int minCnt = Math.abs(n - 100);
        for (int i = 0; i < (int)1e6; i++) {
            String s = String.valueOf(i);
            int len = 0;
            boolean isNotValid = false;
            for(char c : s.toCharArray()) {
                if (isBroken[c - '0']) {
                    isNotValid = true;
                    break;
                }
                else ++len;
            }
            if(isNotValid) continue;
            minCnt = Math.min(minCnt, len + Math.abs(n - i));
        }
        System.out.println(minCnt);
    }
}
