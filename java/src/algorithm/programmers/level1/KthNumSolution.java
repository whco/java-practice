package algorithm.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class KthNumSolution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int[] command : commands){
            int[] arr = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(arr);
            ans.add(arr[command[2] - 1]);
        }
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        KthNumSolution kns = new KthNumSolution();
        int[] answer = kns.solution(array, commands);
        for (int i = 0; i < answer.length; i++) {
            System.out.printf("%d ", answer[i]);
        }
        int[] realAns = {5, 6, 3};

    }


}
