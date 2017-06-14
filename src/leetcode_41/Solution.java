package leetcode_41;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0 ;i < n; i++){
            int tmp = i;
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++){
            if (nums[i] != i + 1){
                return i+1;
            }
        }
        return n + 1;
    }
    public void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}