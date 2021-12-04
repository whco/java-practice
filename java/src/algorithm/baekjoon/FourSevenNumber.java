package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FourSevenNumber {
//    private static ArrayList<Integer> fsNum = new ArrayList<>();
    private static int from;
    private static int to;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        bfs("", 4);
        bfs("", 7);
//        System.out.println(fsNum.size());
        System.out.println(cnt);
    }

    private static void bfs(String s, int nextNum) {
        if(s.length() >= 9) return;
        s += nextNum;
        int n = Integer.parseInt(s);
        if (from <= n && n <= to) ++cnt;
//            fsNum.add(n);
        if(n > to) return;
        bfs(s, 4);
        bfs(s, 7);
    }
}
