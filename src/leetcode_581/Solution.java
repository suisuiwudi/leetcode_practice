package leetcode_581;

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int begin = -1;
        int end = -2;
        int min = nums[n - 1];
        int max = nums[0];
        for (int i = 0; i < n; i++){
            if (nums[i] > max) max = nums[i];
            if (nums[n - i - 1] < min) min = nums[n - i - 1];
            if (nums[i] < max) end = i;
            if (nums[n - i - 1] > min) begin = n - i - 1;
        }
        return end - begin + 1;
    }
}