package algorithm.programmers.level1;

import java.util.HashSet;

public class PrimeThreeSolution {
    public int solution(int[] nums) {
        HashSet<Integer> primeNums = new HashSet<>();
        int answer = 0;
        int size = 3000;
        boolean[] isPrime = new boolean[size + 1];
        for (int i = 0; i <= size; i++) {
            if (i <= 1) isPrime[i] = false;
            else isPrime[i] = true;
        }
        for (int i = 2; i <= size; i++) {
            if (isPrime[i]) {
                primeNums.add(i);
                for (int j = i ; j * i <= size ; j++) {
                    isPrime[j * i] = false;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    if(isPrime[num])
                        answer += 1;
                }
            }
        }


        
        return 0;
    }

//    public static void main(String[] args) {
//        PrimeThreeSolution pts = new PrimeThreeSolution();
//        pts.solution(new int[]{1,2,3});
//    }
}
