package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WineTasting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        //0 : i번째 안 마심 1 : 1번 연속, 2 : 2번 연속
        int[] wine = new int[n];
        int[][] wineConsecutive = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            wine[i] = Integer.parseInt(st.nextToken());
            if(i == 0){
                wineConsecutive[i][1] = wine[i];
                continue;
            }
            wineConsecutive[i][0] = Math.max(wineConsecutive[i - 1][0],
                    Math.max(wineConsecutive[i - 1][1], wineConsecutive[i - 1][2]));
            wineConsecutive[i][1] = wineConsecutive[i - 1][0] + wine[i];
            wineConsecutive[i][2] = wineConsecutive[i - 1][1] + wine[i];
        }
        System.out.println(Math.max(wineConsecutive[n - 1][0], Math.max(wineConsecutive[n - 1][1], wineConsecutive[n - 1][2])));
    }
}
