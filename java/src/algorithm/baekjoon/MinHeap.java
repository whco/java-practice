package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MinHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp == 0){
                int r = minHeap.isEmpty() ? 0 : minHeap.poll();
                sb.append(r + "\n");
            } else {
                minHeap.add(tmp);
            }
        }
        System.out.println(sb);
    }
}
