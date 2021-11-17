package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumDecomposition {

    private static final int MOD = (int)1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] numOfCases = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(i == 0){
                    numOfCases[i][j] = 1;
                    continue;
                }
                if(j == 1){
                    numOfCases[i][j] = 1;
                    continue;
                }
                int sum = 0;
                for (int k = 0; k <= i; k++) {
                    sum += numOfCases[k][j -1];
                    sum %= MOD;
                }
                numOfCases[i][j] = sum;
            }
        }

        System.out.println(numOfCases[n][m]);
    }
}

