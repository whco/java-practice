package basics;

import java.util.HashSet;

public class Test2 {
    int x;
    public static void main(String[] args) {
//        Test2 t = null;
//        if(t == null || t.x == 1)
//            System.out.println("it ends in the first condition");
//        HashSet<Integer> set = new HashSet<>();
//        StringBuffer sb = new StringBuffer();
//        for(int i = 0; i < 200000; ++i)
//            sb.append('S');
//        System.out.println(sb);
        int[][] a = new int[][]{{1,2,3}, {4,5,6}};
        int[][] b = new int[][]{{7,8,9},{10,11,12}};

        b = cp(a);
        a[0][0] = 10;
        System.out.println(b[0][0]);
    }

    public static int[][] cp(int[][] a) {
        int[][] newA = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                newA[i][j] = a[i][j];
            }
        }
        return newA;
    }

    public static void cvr(HashSet<Integer> set, int x){
        if(set.contains(x)) System.out.println("contains");
    }
}
