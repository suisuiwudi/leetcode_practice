package leetcode_16;

import java.util.Arrays;

public class Solution2 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        long ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
                int left = i + 1;
                int right = nums.length - 1;
                
                while (left < right && left > i){
                    if (Math.abs(nums[i] + nums[left] + nums[right] - target) < Math.abs(ans - target)) ans = nums[i] + nums[left] + nums[right];
                    if (nums[i] + nums[left] + nums[right] > target){
                        right--;
                    } else if (nums[i] + nums[left] + nums[right] < target){
                        left++;
                    } else {
                        return nums[i] + nums[left] + nums[right];
                    }
                    
                }
        }
        return (int)ans;
    }
}