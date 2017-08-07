package leetcode_34;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        if (nums.length == 0) return ans;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left > nums.length-1 || nums[left] != target) return ans;
        ans[0] = left;
        left = left + 1;
        right = nums.length - 1;
        while (left <= right){
            int mid = (left+right) / 2;
            if (nums[mid] <= target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        ans[1] = right;
        return ans;
    }
}