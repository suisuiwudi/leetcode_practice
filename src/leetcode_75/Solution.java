package leetcode_75;

public class Solution {
    public void sortColors(int[] nums) {
        int second = nums.length - 1;
        int zero = 0;
        for (int i = 0; i <=second; i++){
            while (nums[i] == 2 && i < second) swap(i, second--,nums);
            while (nums[i] == 0 && i > zero) swap(i, zero++, nums);
        }
    }
    public void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}