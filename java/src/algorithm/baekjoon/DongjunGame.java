package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DongjunGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        int n = Integer.parseInt(st.nextToken());
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n - 2; i >= 0 ; --i) {
            if(score[i] >= score[i + 1]){
                sum += score[i] - score[i + 1] + 1;
                score[i] = score[i + 1] - 1;
            }
        }

        System.out.println(sum);
    }
}
