package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2011_PasswordCode {
    static int[] cases;
    static String password;
    private static final int MOD = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        password = br.readLine();
        cases = new int[password.length()];
        cases[0] = password.charAt(0) == '0' ? 0 : 1;
        if(password.length() > 1 && cases[0] != 0) {
            //121074110
            for (int i = 1; i < cases.length; ++i) {
                int prev2 = i <= 1 ? 1 : cases[i - 2];
                if (password.charAt(i) == '0') {
                    if (!"12".contains(String.valueOf(password.charAt(i - 1)))) {
                        cases[cases.length - 1] = 0;
                        break;
                    }
                    cases[i] = prev2;
                    cases[i - 1] = 0;
                } else {
                    cases[i] = (cases[i - 1] + (isInValidRange(i) ? prev2 : 0)) % MOD;
                }
            }
        }
        System.out.println(cases[cases.length - 1]);
    }
    //
    private static boolean isInValidRange(int i){
        int subStrToNum = Integer.parseInt(password.substring(i - 1, i + 1));
       return 1 <= subStrToNum && subStrToNum <= 26;
    }

}
