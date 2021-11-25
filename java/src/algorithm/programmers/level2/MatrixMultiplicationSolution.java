package algorithm.programmers.level2;

public class MatrixMultiplicationSolution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int i = 0; i < arr1.length; ++i)
            for(int k = 0; k < arr2[0].length; ++k)
                for(int j = 0; j < arr2.length; ++j)
                    answer[i][k] += arr1[i][j] * arr2[j][k];
        return answer;
    }
}
