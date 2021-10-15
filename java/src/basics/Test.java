package basics;

import java.util.ArrayList;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        System.out.println("test");
        ArrayList<Stack<Integer>> s = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            s.add(new Stack<Integer>());
        }
        System.out.println(s.size());
    }
}
