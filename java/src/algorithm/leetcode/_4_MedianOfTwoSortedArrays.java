package algorithm.leetcode;

public class _4_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //O(m + n) solution, need to be corrected
        int len = nums1.length + nums2.length;
        int[] nums = new int[len];
        int i = 0, i1 = 0, i2 = 0;
        // if(nums2.length == 0) return median(nums1);
        while (i <= len / 2) {
            if (i2 == nums2.length || (i1 < nums1.length && nums1[i1] <= nums2[i2])) {
                nums[i++] = nums1[i1++];
            } else {
                nums[i++] = nums2[i2++];
            }
        }
        return median(nums);
    }

    private double median(int[] arr) {
        return arr.length % 2 == 0 ? (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2.0
                : arr[arr.length / 2];
    }
}
