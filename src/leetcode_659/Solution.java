package leetcode_659;

class Solution {
    public boolean isPossible(int[] nums) {
        int pre = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] - nums[i-1] > 1){
                if (!check(nums,pre,i)){
                    return false;
                }
                pre = i;
            }
        }
        return check(nums,pre,nums.length);
    }
    public boolean check(int[] nums, int start, int end){//start 
        int ones = 0;
        int twos = 0;
        int lasts = 0;
        int count = 1;
        for (int i = start + 1; i <= end; i++){
            if (i < end && nums[i] == nums[i - 1]){
                count++;
            } else {
                if (count < ones + twos) return false;
                twos = ones;
                ones = Math.max(0, count - lasts);
                lasts = count;
                count = 1;
            }
        }
        return ones == 0 && twos == 0;
    }
}
