package leetcode_209;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int last = 0;
        int num = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            if (nums[i]+num < s) num += nums[i];
            else{
                num += nums[i];
                while ( num - nums[last] >=s ){
                    num -=nums[last++];
                }
                if (num >= s){
                    ans = Math.min(ans,i - last + 1);
                }
            }
        }
        if (ans == Integer.MAX_VALUE) return 0;
        return ans;
    }
}