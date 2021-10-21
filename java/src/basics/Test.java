package basics;

import java.util.Arrays;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hm = new HashMap();
        hm.put(1, 1);
        hm.replace(1, hm.get(1) + 1);
        hm.put(1, 5);
        hm.replace(2, hm.get(1) + 1);
        System.out.println(hm.get(1));
        int[] arr = {1, 3, 5, 4, 4, 3};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }
}
