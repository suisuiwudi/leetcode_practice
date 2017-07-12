package leetcode_81;

public class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
            while (left <= right){
                int mid = (left + right) / 2;
                if (nums[mid] == target) return true;
                if (nums[mid] > nums[left]){
                    if (nums[mid] > target && target >= nums[left]){
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                    
                } else if (nums[mid] < nums[left]){
                    if (target > nums[mid] && target < nums[left]){
                        left = mid + 1;
                    } else {
                        right = mid - 1;    
                    }
                } else {
                    left++;
                }
            }
        return false;
    }
}