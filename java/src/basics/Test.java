package basics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
//        HashMap<Integer, Integer> hm = new HashMapSpliterator();
//        hm.put(1, 1);
//        hm.replace(1, hm.get(1) + 1);
//        hm.put(1, 5);
//        hm.replace(2, hm.get(1) + 1);
//        System.out.println(hm.get(1));
//        int[] arr = {1, 3, 5, 4, 4, 3};
//        Arrays.sort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.printf("%d ", arr[i]);
//        }

//        StringBuffer sb = new StringBuffer();
//        for (int i = 2; i <= 10; i++) {
//            System.out.println(Integer.parseInt("435", i));
//        }
//        System.out.println(Integer.parseInt("32",4));
//
//        int[] arr = {1, 3, 2};
//        System.out.println("aabbaccc".length());

//        Set<Integer> set = new HashSet<>();
//        String s = "abcabc";
//        System.out.println(s.startsWith("abc"));
        System.out.println(plusReturn(5));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(3);
        pq.add(8);
        pq.add(2);
        pq.remove();
        HashSet<Integer> hs = new HashSet<>();
        hs.add(3);
        hs.remove(3);

        int[] arr = {1, 3, 5, 2, 5, 7};
//        Arrays.sort(arr, Collections.reverseOrder());
        Integer[] ar = new Integer[21];
        System.out.println(ar[3]);
//        Arrays.sort(ar, Collections.reverseOrder());
//        System.out.println(ar[3]);
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lst.add(i);
        }

    }

    public static int plusReturn(int n) {
        int x = 3;
        return x += n;
    }
}
