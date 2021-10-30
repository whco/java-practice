package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class StudyRoomDistancing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, T, P;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

//        TreeSet<Integer> occupied = new TreeSet<>();
//        SortedSet<Integer> occupied = new SortedSet<Integer>();
    }

    public int nextSeat(TreeSet<Integer> occupied, int n) {
        int min = n;
        for (int i = 1; i <= n; ++i) {
            if(occupied.contains(i)) continue;
            Integer lower = occupied.lower(i);
            Integer higher = occupied.higher(i);
        }
    }

    public class Time {
        int h;
        int m;

        public Time(int h, int m) {
            this.h = h;
            this.m = m;
        }

        public Time(String time){
            String[] t = time.split(":");
            this.h = Integer.parseInt(t[0]);
            this.m = Integer.parseInt(t[1]);
        }

        public boolean isSmallerThan(Time t){
            if(this.h == t.h) return this.m < t.h;
            return this.h < t.h;
        }

        public boolean isLargerThan(Time t) {
            if(this.h == t.h) return this.h > t.h;
            return this.h > t.h;
        }
    }
}
