package algorithm;

import java.util.ArrayList;
import java.util.Stack;

public class CrainSolution {
    ArrayList<Stack<Integer>> boardStack = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < n; i++) {
            boardStack.add(new Stack<>());
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] != 0)
                    boardStack.get(j).push(board[i][j]);
            }
        }

        for (int move : moves) {
            if (!boardStack.get(move - 1).empty()) {
                int t = boardStack.get(move - 1).pop();
                if (!stack.empty() && stack.peek() == t) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(t);
                }
            }

        }



        return answer;
    }

    public static void main(String[] args) {
        String s = "[[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]";

        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()) {
            if (c == '[')
                sb.append('{');
            else if (c == ']')
                sb.append('}');
            else sb.append(c);
        }
        System.out.println(sb.toString());

        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        CrainSolution cs = new CrainSolution();
        System.out.println(cs.solution(board, moves));

    }
}
