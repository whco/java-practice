package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EvenPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int front = 0;
        int cnt = 0;
        for (int i = 1; i < n; i += 2) {
            if(isPalindrome(arr, front, i)){
                front = i + 1;
                ++cnt;
            }
        }
        System.out.println(front == n ? cnt : -1);
    }

    public static boolean isPalindrome(int[] arr, int front, int end) {
        for (int i = 0; front + i < end - i; i++) {
            if(arr[front + i] != arr[end - i]) return false;
        }
        return true;
    }
}
