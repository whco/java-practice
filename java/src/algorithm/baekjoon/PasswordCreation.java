package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class PasswordCreation {
    private static final HashSet<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    private static final int minVowel = 1, minConsonant = 2;
    private static StringBuffer sb = new StringBuffer();
    private static int l;
    private static int c;
    private static char[] chars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        chars = new char[c];
        boolean[] isUsed = new boolean[c];
        for (int i = 0; i < c; i++) {
            chars[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(chars);
        dfs("", 0, 0, 0, true);
        dfs("", 0, 0, 0, false);
        System.out.println(sb);
    }

    private static void dfs(String s, int newCharIdx, int vCnt, int cCnt, boolean use) {
        if (use) {
            s += chars[newCharIdx];
            if (vowel.contains(chars[newCharIdx])) ++vCnt;
            else ++cCnt;
        }
        if (s.length() == l) {
            if (vCnt >= minVowel && cCnt >= minConsonant)
                sb.append(s + "\n");
            return;
        } else if (newCharIdx == c - 1) return;
        dfs(s, newCharIdx + 1, vCnt, cCnt, true);
        dfs(s, newCharIdx + 1, vCnt, cCnt, false);
    }
}
