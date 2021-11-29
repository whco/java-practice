package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DiagonalOverTiles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int sum = x + y;
        while (x % y != 0 && y % x != 0) {
            if(x > y) x -= y * (x / y);
            else y -= x * (y / x);
        }
        System.out.println(sum - Math.min(x, y));
    }
}
