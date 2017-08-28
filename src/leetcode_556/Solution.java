package leetcode_556;

import java.util.Arrays;

class Solution {
    public int nextGreaterElement(int n) {
        char[] nums = (n + "").toCharArray();
        int i = 0;
        for (i = nums.length - 1; i >= 0; i--){
            if (i == 0) return -1;
            if (nums[i] > nums[i-1]){
                break;
            }
        }
        int j = 0;
        for (j = nums.length - 1; j >= i; j--){
            if (nums[j] > nums[i - 1]) break;
        }
        char tmp = nums[j];
        nums[j] = nums[i-1];
        nums[i-1] = tmp;
        Arrays.sort(nums,i,nums.length);
        long ans = Long.parseLong(new String(nums));
        if (ans > Integer.MAX_VALUE) return -1;
        else return (int) ans;
    }
}