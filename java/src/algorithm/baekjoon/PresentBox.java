package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PresentBox {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        double front = 0;
        double back = Math.max(l, Math.max(w, h));
        double a = (front + back) / 2;;
        while(back - front > 1e-9){
            if(boxNum(a, l, w, h) < (long) n ) back = a;
            else front = a;
            a = (front + back) / 2;
        }
        System.out.println(a);
    }

    private static long boxNum(double a, int l, int w, int h) {
        return (long) (l / a) * (long) (w / a) * (long) (h / a);
    }
}
