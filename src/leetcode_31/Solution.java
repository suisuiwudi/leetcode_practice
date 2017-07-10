package leetcode_31;

public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        int i,j = -1;
        for (i = nums.length - 1; i >= 1; i--){
            if (nums[i] > nums[i-1]){
                j = i - 1;
                break;
            }
        }
        if (i == 0){
            reverse(nums,0,nums.length - 1);
        } else {
            for (i = nums.length - 1; i >= 1; i--){
                if (nums[i] > nums[j]){
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    break;
                }
            }
            reverse(nums,j+1,nums.length - 1);
         }
    }
    public void reverse(int[] nums, int start, int end){
        while (start < end){
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }
}