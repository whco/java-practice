package algorithm.programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class ExpressionMaximizationSolution {
    public static void main(String[] args) {
        ExpressionMaximizationSolution s = new ExpressionMaximizationSolution();
        System.out.println(s.solution("100-200*300-500+20"));
    }
    List<Long> operands = new ArrayList<>();
    List<Long> operandsCopy;
    List<Character> operators = new ArrayList<>();
    List<Character> operatorsCopy;
    char[] operatorChars = new char[]{'+', '-', '*'};
    long max = 0;
    public long solution(String expression) {
        parse(expression);
        permutations(operatorChars);
        return max;
    }

    private void permutations(char[] arr) {
        permutations(arr, 3, 3, 0);
    }

    private void permutations(char[] arr, int n, int r, int depth) {
        if (depth == r) {
            calculateResult();
            return;
        }
        for (int i = depth; i < n; ++i) {
            swap(arr, depth, i);
            permutations(arr, n, r, depth + 1);
            swap(arr, depth, i);
        }
    }

    private void calculateResult() {
        long result = 0;
        operandsCopy = new ArrayList<>(operands);
        operatorsCopy = new ArrayList<>(operators);
        for (char op : operatorChars) {
            for(int i = 0; i < operatorsCopy.size();){
                if(operatorsCopy.get(i) == op) {
                    result = calculate(operandsCopy, operatorsCopy, i);
                } else ++i;
            }
        }
        max = Math.max(max, Math.abs(result));
    }

    private long calculate(List<Long> operandsCopy, List<Character> operatorsCopy, int i) {
        long result = 0;
        long op1 = operandsCopy.get(i);
        long op2 = operandsCopy.get(i + 1);
        char operator = operatorsCopy.get(i);

        if(operator == '-') result = op1 - op2;
        else if(operator == '+') result = op1 + op2;
        else if(operator == '*') result = op1 * op2;

        operatorsCopy.remove(i);
        operandsCopy.remove(i);
        operandsCopy.set(i, result);
        return result;
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void parse(String expression) {
        int lastIdx = -1;
        for (int i = 0; i <= expression.length(); i++) {
            if (i == expression.length() || isOperator(expression.charAt(i))) {
                long operand = Long.parseLong(expression.substring(lastIdx + 1, i));
                operands.add(operand);
                if(i != expression.length())
                    operators.add(expression.charAt(i));
                lastIdx = i;
            }
        }
    }

    private boolean isOperator(char c) {
        for(char op : operatorChars)
            if(op == c) return true;
        return false;
    }
}
