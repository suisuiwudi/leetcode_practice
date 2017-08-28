package leetcode_152;

class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] < 0){
                int oldmax = max;
                max = Math.max(min * nums[i], nums[i]);
                min = Math.min(oldmax * nums[i], nums[i]);
            } else {
                max = Math.max(max * nums[i], nums[i]);
                min = Math.min(min * nums[i], nums[i]);
            }
            ans = Math.max(ans, max);
        }
        return ans;
    }
}