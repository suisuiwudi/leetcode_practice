package leetcode_162;

public class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0 ;
        int right = nums.length - 1;
        while (left < right){
            int mid1 = (left + right) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1]>nums[mid2])
                right = mid1;
            else
                left = mid2;
        }
        return left;
    }
}