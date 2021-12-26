package basics;

import java.util.HashSet;

public class Test2 {
    int x;
    public static void main(String[] args) {
        Test2 t = null;
        if(t == null || t.x == 1)
            System.out.println("it ends in the first condition");
        HashSet<Integer> set = new HashSet<>();
    }

    public static void cvr(HashSet<Integer> set, int x){
        if(set.contains(x)) System.out.println("contains");
    }
}
