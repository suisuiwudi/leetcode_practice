package leetcode_16;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        long ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int second = i + 1, third = nums.length - 1; second < third; second++){
                if (second > i + 1 && nums[second] == nums[second - 1]) continue;
                int left = second + 1;
                int right = third;
                
                while (left <= right){
                    int mid = (left + right) / 2;
                    if (nums[i] + nums[second] + nums[mid] > target){
                        right = mid - 1;
                        
                    } else if (nums[i] + nums[second] + nums[mid] < target){
                        left = mid + 1;
                    } else {
                        return nums[i] + nums[second] + nums[mid];
                    }
                    if (Math.abs(nums[i] + nums[second] + nums[mid] - target) < Math.abs(ans - target)) ans = nums[i]+nums[second]+nums[mid];
                }
                third = right;
                
            }  
        }
        return (int)ans;
    }
}