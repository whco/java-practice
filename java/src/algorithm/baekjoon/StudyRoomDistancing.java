package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StudyRoomDistancing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, T, P;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

//        TreeSet<Integer> occupied = new TreeSet<>();
//        ArrayList<Integer> occupied = new ArrayList<>();
//        HashSet<Integer> occupied = new HashSet<>();

        ArrayList<ArrayList<String>> reservedTime = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            ArrayList<String> time = new ArrayList<>();
            time.add(st.nextToken());
            time.add(st.nextToken());
            reservedTime.add(time);
        }
    }

    public static int nextSeat(HashSet<Integer> occupied, int n) {
        if(occupied.isEmpty()) return 1;

        ArrayList<Integer> occupiedList = new ArrayList<>(occupied);
        Collections.sort(occupiedList);

        int maxMin = 0;
        int maxMinIdx = n;

        for (int i = n; i >= 1; --i) {
            if(minDistance(occupiedList, i) >= maxMin){
//                System.out.println("i : " + i);
                maxMin = minDistance(occupiedList, i);
                maxMinIdx = i;
            }
        }

        return maxMinIdx;

    }

    public static int minDistance(ArrayList<Integer> lst, int i) {
        int min = 100;
        for (int j = 0; j < lst.size(); j++) {
            if(Math.abs(lst.get(j) - i) < min)
                min = Math.abs(lst.get(j) - i);
        }
        return min;
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
