package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10953_AplusB6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String line = br.readLine();
            String[] lineSplit = line.split(",");
            System.out.println(Integer.parseInt(lineSplit[0]) + Integer.parseInt(lineSplit[1]));
        }
    }
}
