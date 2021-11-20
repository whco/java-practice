package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class AmazingPrimeNum {

    private static HashSet<Integer> primeNum = new HashSet<>();
    private static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        primeNum.add(2);
        primeNum.add(3);
        primeNum.add(5);
        primeNum.add(7);

        dfs(2, n);
        dfs(3, n);
        dfs(5, n);
        dfs(7, n);


        System.out.println(sb);
    }

    public static void dfs(int i, int n) {
        if(!isPrimeNum(i)) return;
        String s = Integer.toString(i);
        if(s.length() == n) {
            if(isPrimeNum(i)){ sb.append(s + "\n");}
            return;
        }
        dfs(Integer.parseInt(s + "1"), n);
        dfs(Integer.parseInt(s + "3"), n);
        dfs(Integer.parseInt(s + "5"), n);
        dfs(Integer.parseInt(s + "7"), n);
        dfs(Integer.parseInt(s + "9"), n);

    }

    private static boolean isPrimeNum(int n) {
        for (int i = 2; i * i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

}
