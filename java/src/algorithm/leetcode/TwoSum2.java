package algorithm.leetcode;

import java.util.HashMap;

public class TwoSum2 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
            if(numMap.containsKey(target - nums[i])) return new int[]{i, numMap.get(target - nums[i])};
            numMap.put(nums[i], i);
        }
        return null;
    }
}
