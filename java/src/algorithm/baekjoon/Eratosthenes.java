package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Eratosthenes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= N; i++) {
            if(isPrime[i]){
                for (int j = 1; j * i <= N; j++) {
                    if(isPrime[j * i]){
                        isPrime[j * i] = false;
//                        System.out.println(cnt);
                        if(++cnt == K)
                            System.out.println(j * i);
                    }
                }
            }
        }
    }
}
