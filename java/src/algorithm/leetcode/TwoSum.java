package algorithm.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Arrays.sort(nums);
        int resultIdx = -1;
        int[] sortedIdx = new int[2];
        for(int i = 0; i < nums.length; ++i){
            if((resultIdx = findIdxInSortedArray(nums, target - nums[i])) != -1){
                answer[0] = numsList.indexOf(nums[i]);
                answer[1] = numsList.lastIndexOf(nums[resultIdx]);
            }
        }
        return answer;
    }

    int findIdxInSortedArray(int[] a, int target){
        return findIdxInSortedArray(a, target, 0, a.length);
    }
    //a : sorted, search range : [l, r)
    int findIdxInSortedArray(int[] a, int target, int l, int r){
        if(r - l <= 1){
            if(l < a.length && a[l] == target) return l;
            return -1;
        }
        int m = (r + l) / 2;
        if(a[m] == target) return m;
        else if(a[m] > target) return findIdxInSortedArray(a, target, l, m);
        else return findIdxInSortedArray(a, target, m + 1, r);
    }
}
