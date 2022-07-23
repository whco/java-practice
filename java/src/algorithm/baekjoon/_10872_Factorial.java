package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10872_Factorial {
    public static void main(String[] args) throws IOException {
        //0 <= N <= 12
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int factorial = 1;
        while (n > 0) factorial *= n--;

        System.out.println(factorial);
    }

}
