package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class IntervalMeanOfSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        HashMap<Long, Integer> map = new HashMap<>();
        int[] seq = new int[n];
        long[] preSum = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken()) - k;
            seq[i] = tmp;
            if(i == 0) preSum[0] = seq[0];
            else preSum[i] = preSum[i - 1] + (long) seq[i];
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }
        long ans = 0;
        for (Long key : map.keySet()) {
            if(key == 0) ans += map.get(key);
            ans += (long) map.get(key) * (map.get(key) - 1) / 2;
        }
        System.out.println(ans);
    }
}
