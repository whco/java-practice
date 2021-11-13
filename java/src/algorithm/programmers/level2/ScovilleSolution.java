package algorithm.programmers.level2;

import java.util.PriorityQueue;

class ScovilleSolution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> sc = new PriorityQueue<>();
        for(int s : scoville)
            sc.add(s);
        int cnt = 0;
        while(sc.size() > 1) {
            int a = sc.poll();
            int b = sc.poll();
            sc.add(a + b * 2);
            ++cnt;
            if(sc.peek() >= K) return cnt;
        }
        return -1;

    }
}