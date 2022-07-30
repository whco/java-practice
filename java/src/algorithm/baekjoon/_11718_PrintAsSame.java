package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11718_PrintAsSame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 10000);
        StringBuilder sb = new StringBuilder(10000);

        String s;
        while ((s = br.readLine()) != null) {
            sb.append(s).append('\n');
        }

        System.out.println(sb);
    }
}
