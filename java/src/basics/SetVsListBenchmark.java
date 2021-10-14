package basics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetVsListBenchmark {

    public static void main(String[] args) {
        long size = (long)1e6;
        long bt = System.nanoTime();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            al.add(i);
        }
        long at = System.nanoTime();
        System.out.println("ArrayList Construction: " + (at - bt) / 1000000.0 + "ms");

        long bt2 = System.nanoTime();
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < size; i++) {
            hs.add(i);
        }
        long at2 = System.nanoTime();
        System.out.println("HashSet Construction: " + (at2 - bt2) / 1000000.0 + "ms");

        long bt3 = System.nanoTime();
        al.contains(size/2);
        long at3 = System.nanoTime();
        System.out.println("ArrayList contains : " + (at3 - bt3) / 1000000.0 + "ms");

        long bt4 = System.nanoTime();
        hs.contains(size/2);
        long at4 = System.nanoTime();
        System.out.println("HashSet contains : " + (at4 - bt4) / 1000000.0 + "ms");
    }
}
