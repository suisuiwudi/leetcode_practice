package leetcode_611;

import java.util.Arrays;

public class Solution {
    public int triangleNumber(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++){
            for (int j = i + 1; j < nums.length - 1; j++){
                int left = j + 1;
                int right = nums.length - 1;
                while (left <= right){
                    int mid = (left + right) / 2;
                    if (nums[mid] < nums[i] + nums[j]){
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                ans += right - j;
            }
        }
        return ans;
    }
}