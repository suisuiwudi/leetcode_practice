package leetcode_189;

public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0 || nums.length == 0) return;
        reverse(nums,0,nums.length - k - 1);
        reverse(nums,nums.length - k,nums.length - 1);
        reverse(nums,0, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end){
        if (start > end){
            return;
        }
        while (start<=end){
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }
}